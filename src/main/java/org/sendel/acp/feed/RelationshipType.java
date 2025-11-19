package org.sendel.acp.feed;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Product relationship type enumeration.
 */
public enum RelationshipType {
    PART_OF_SET("part_of_set"),
    REQUIRED_PART("required_part"),
    OFTEN_BOUGHT_WITH("often_bought_with"),
    SUBSTITUTE("substitute"),
    DIFFERENT_BRAND("different_brand"),
    ACCESSORY("accessory");

    private final String value;

    RelationshipType(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static RelationshipType fromValue(String value) {
        for (RelationshipType type : values()) {
            if (type.value.equals(value)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown relationship type: " + value);
    }
}
