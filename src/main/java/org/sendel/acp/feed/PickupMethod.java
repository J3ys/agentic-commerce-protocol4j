package org.sendel.acp.feed;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Pickup method enumeration.
 */
public enum PickupMethod {
    IN_STORE("in_store"),
    RESERVE("reserve"),
    NOT_SUPPORTED("not_supported");

    private final String value;

    PickupMethod(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static PickupMethod fromValue(String value) {
        for (PickupMethod method : values()) {
            if (method.value.equals(value)) {
                return method;
            }
        }
        throw new IllegalArgumentException("Unknown pickup method: " + value);
    }
}