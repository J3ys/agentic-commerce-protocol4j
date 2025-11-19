package org.sendel.acp.feed;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Age group enumeration for products.
 */
public enum AgeGroup {
    NEWBORN("newborn"),
    INFANT("infant"),
    TODDLER("toddler"),
    KIDS("kids"),
    ADULT("adult");

    private final String value;

    AgeGroup(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static AgeGroup fromValue(String value) {
        for (AgeGroup ageGroup : values()) {
            if (ageGroup.value.equals(value)) {
                return ageGroup;
            }
        }
        throw new IllegalArgumentException("Unknown age group: " + value);
    }
}