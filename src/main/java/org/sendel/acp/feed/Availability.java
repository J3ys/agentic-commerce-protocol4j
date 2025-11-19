package org.sendel.acp.feed;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Product availability status enumeration.
 */
public enum Availability {
    IN_STOCK("in_stock"),
    OUT_OF_STOCK("out_of_stock"),
    PREORDER("preorder");

    private final String value;

    Availability(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static Availability fromValue(String value) {
        for (Availability availability : values()) {
            if (availability.value.equals(value)) {
                return availability;
            }
        }
        throw new IllegalArgumentException("Unknown availability: " + value);
    }
}