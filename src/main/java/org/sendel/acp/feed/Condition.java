package org.sendel.acp.feed;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Product condition enumeration.
 */
public enum Condition {
    NEW("new"),
    REFURBISHED("refurbished"),
    USED("used");

    private final String value;

    Condition(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static Condition fromValue(String value) {
        for (Condition condition : values()) {
            if (condition.value.equals(value)) {
                return condition;
            }
        }
        throw new IllegalArgumentException("Unknown condition: " + value);
    }
}