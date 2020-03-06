package com.moskovkin.vlm.util;

import com.moskovkin.vlm.domain.type.JavaType;
import com.moskovkin.vlm.domain.type.Type;

public final class TypeChecker {
    public static boolean isInt(Type type) {
        return type == JavaType.INT;
    }

    public static boolean isBool(Type type) {
        return type == JavaType.BOOLEAN;
    }

    public static boolean isFloat(Type type) {
        return type == JavaType.FLOAT;
    }

    public static boolean isDouble(Type type) {
        return type == JavaType.DOUBLE;
    }
}
