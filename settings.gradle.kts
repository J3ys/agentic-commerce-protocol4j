rootProject.name = "agentic-commerce-protocol4j"

pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
}

plugins {
    // Enables type-safe project accessors if you add subprojects later
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.9.0" apply false
}
