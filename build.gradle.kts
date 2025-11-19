plugins {
    `java-library`
    `maven-publish`
    signing
    id("io.github.gradle-nexus.publish-plugin") version "2.0.0"
    id("org.openapi.generator") version "7.6.0"
}

repositories {
    mavenCentral()
}

dependencies {
    // OpenAPI generator runtime dependencies
    implementation("com.google.code.gson:gson:2.10.1")
    implementation("io.gsonfire:gson-fire:1.9.0")
    implementation("com.squareup.okio:okio:3.6.0")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.15.3")
    implementation("jakarta.annotation:jakarta.annotation-api:2.1.1")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of((providers.gradleProperty("javaVersion").orElse("17")).get().toInt()))
    }
    withSourcesJar()
    withJavadocJar()
}

group = providers.gradleProperty("GROUP").getOrElse("com.example")
version = providers.gradleProperty("VERSION_NAME").getOrElse("0.1.0-SNAPSHOT")

tasks.withType<Javadoc>().configureEach {
    options.encoding = "UTF-8"
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])

            pom {
                name.set(providers.gradleProperty("POM_NAME").orElse(provider { project.name }))
                description.set(providers.gradleProperty("POM_DESCRIPTION").orElse(""))
                url.set(providers.gradleProperty("POM_URL").orElse(""))

                licenses {
                    license {
                        name.set(providers.gradleProperty("POM_LICENSE_NAME").orElse("The Apache License, Version 2.0"))
                        url.set(providers.gradleProperty("POM_LICENSE_URL").orElse("https://www.apache.org/licenses/LICENSE-2.0.txt"))
                        distribution.set(providers.gradleProperty("POM_LICENSE_DIST").orElse("repo"))
                    }
                }
                developers {
                    developer {
                        id.set(providers.gradleProperty("POM_DEVELOPER_ID").orElse("developer"))
                        name.set(providers.gradleProperty("POM_DEVELOPER_NAME").orElse("Developer Name"))
                        email.set(providers.gradleProperty("POM_DEVELOPER_EMAIL").orElse("dev@example.com"))
                    }
                }
                scm {
                    url.set(providers.gradleProperty("POM_SCM_URL").orElse(""))
                    connection.set(providers.gradleProperty("POM_SCM_CONNECTION").orElse(""))
                    developerConnection.set(providers.gradleProperty("POM_SCM_DEV_CONNECTION").orElse(""))
                }
            }
        }
    }

    repositories {
        mavenLocal()
    }
}

// Signing configuration for Sonatype publishing (used by GitHub Actions)
// Optional - only signs when keys are provided via environment variables
signing {
    val signingKey = providers.environmentVariable("SIGNING_KEY")
    val signingPassword = providers.environmentVariable("SIGNING_PASSWORD")

    // Only require signing when credentials are present
    isRequired = signingKey.isPresent && signingPassword.isPresent

    if (signingKey.isPresent && signingPassword.isPresent) {
        useInMemoryPgpKeys(signingKey.get(), signingPassword.get())
        sign(publishing.publications["mavenJava"])
    }
}

// Sonatype publishing configuration (used by GitHub Actions)
nexusPublishing {
    repositories {
        sonatype {
            nexusUrl.set(uri("https://s01.oss.sonatype.org/service/local/"))
            snapshotRepositoryUrl.set(uri("https://s01.oss.sonatype.org/content/repositories/snapshots/"))

            username.set(providers.environmentVariable("OSSRH_USERNAME"))
            password.set(providers.environmentVariable("OSSRH_PASSWORD"))
        }
    }
}

// Helpful tasks
tasks.register("printVersion") {
    doLast { println("${'$'}group:${'$'}{project.name}:${'$'}version") }
}

// OpenAPI generation and schema packaging
// Now schemas live under src/main/resources/openapi so they are packaged by default.
// You can still override with -PopenapiSpecDir=... or env OPENAPI_SPEC_DIR, and/or a single -PopenapiInputSpec=...
val openapiResourcesPath = "src/main/resources/openapi"
val openapiSpecDirProvider = providers.gradleProperty("openapiSpecDir")
    .orElse(providers.environmentVariable("OPENAPI_SPEC_DIR"))
    .orElse(openapiResourcesPath)

val skipOpenApi = providers.gradleProperty("skipOpenApi").map { it.toBoolean() }.orElse(false)

val openapiGeneratedSrc = layout.buildDirectory.dir("generated/sources/openapi")

// Generate Java sources from OpenAPI using OpenAPI Generator
// Uses either -PopenapiInputSpec or picks the first spec file found in openapiSpecDir
tasks.register<org.openapitools.generator.gradle.plugin.tasks.GenerateTask>("generateOpenApi") {
    onlyIf { !skipOpenApi.get() }

    val explicitSpec = providers.gradleProperty("openapiInputSpec")
        .orElse(providers.environmentVariable("OPENAPI_INPUT_SPEC"))

    val resolvedSpec = providers.provider {
        val provided = explicitSpec.orNull
        if (!provided.isNullOrBlank()) {
            provided
        } else {
            val dir = file(openapiSpecDirProvider.get())
            if (!dir.exists()) return@provider ""
            val files = fileTree(dir).matching {
                include("**/*.yaml", "**/*.yml", "**/*.json")
            }.files.sortedBy { it.name }
            files.firstOrNull()?.absolutePath ?: ""
        }
    }

    doFirst {
        val specPath = resolvedSpec.get()
        if (specPath.isBlank() || !file(specPath).exists()) {
            logger.lifecycle("[generateOpenApi] No OpenAPI spec found. Place files under $openapiResourcesPath or set -PopenapiInputSpec=/path/to/spec.yaml (or OPENAPI_INPUT_SPEC). You can skip with -PskipOpenApi=true.")
            throw GradleException("OpenAPI spec not found: set openapiInputSpec/OPENAPI_INPUT_SPEC or provide a file in ${openapiSpecDirProvider.get()}")
        }
    }

    inputSpec.set(resolvedSpec)
    generatorName.set("java")
    // Place generator output under build/generated/sources/openapi/
    outputDir.set(openapiGeneratedSrc.map { it.asFile.absolutePath })

    // Packages (customize as needed)
    apiPackage.set("org.sendel.acp.api")
    modelPackage.set("org.sendel.acp.model")
    invokerPackage.set("org.sendel.acp.invoker")

    // Generate models and supporting files
    globalProperties.set(mapOf(
        "models" to "",
        "supportingFiles" to "JSON.java,AbstractOpenApiSchema.java,ApiException.java"
    ))

    // Common Java options
    configOptions.set(mapOf(
        "dateLibrary" to "java8",
        "useJakartaEe" to "true",
        "hideGenerationTimestamp" to "true"
    ))
}

// Add generated sources to the main source set so they are compiled and included in sourcesJar
sourceSets {
    named("main") {
        java.srcDir(openapiGeneratedSrc.map { it.dir("src/main/java") })
        // Schemas under src/main/resources/openapi will be packaged automatically into the JAR
    }
}

// Ensure generation happens before compilation
tasks.named<JavaCompile>("compileJava") {
    dependsOn("generateOpenApi")
}

// Ensure sourcesJar contains generated sources
tasks.named<Jar>("sourcesJar") {
    dependsOn("generateOpenApi")
    from(openapiGeneratedSrc.map { it.dir("src/main/java") })
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
}

// Helper to print current OpenAPI configuration
tasks.register("printOpenApiConfig") {
    doLast {
        println("openapiSpecDir=" + openapiSpecDirProvider.get())
        println("skipOpenApi=" + skipOpenApi.get())
    }
}
