package com.moskovkin.vlm.util;

import java.util.Arrays;
import java.util.Objects;

import com.google.common.primitives.Doubles;
import com.google.common.primitives.Floats;
import com.google.common.primitives.Ints;
import com.moskovkin.compiler.vlm.VlmParser.TypeContext;
import com.moskovkin.vlm.domain.type.JavaType;
import com.moskovkin.vlm.domain.type.Type;
import org.apache.commons.lang3.StringUtils;

import static com.moskovkin.compiler.vlm.VlmParser.*;

public class TypeFactory {

    public static Type createType(TypeContext typeContext) {
        String typeName = typeContext.getText();
        Objects.requireNonNull(typeName, "Type should not be null");
        return Arrays.stream(JavaType.values())
                .filter(type -> type.getName().equals(typeName))
                .findAny()
                .orElseThrow(() -> new RuntimeException("There is no such Type"));//TODO implement custom exception
    }

    public static Type getFromValue(ValueContext value) {
        String stringValue = value.getText();
        if (StringUtils.isEmpty(stringValue)) return JavaType.VOID;
        if (value.NUMBER() != null) {
            if (Ints.tryParse(stringValue) != null) {
                return JavaType.INT;
            } else if (Floats.tryParse(stringValue) != null) {
                return JavaType.FLOAT;
            } else if (Doubles.tryParse(stringValue) != null) {
                return JavaType.DOUBLE;
            }
        } else if (value.BOOL() != null) {
            return JavaType.BOOLEAN;
        }
        return JavaType.STRING;
    }

    public static Object getValueFromString(String stringValue, Type type) {
        if (TypeChecker.isInt(type)) {
            return Integer.valueOf(stringValue);
        }
        if (TypeChecker.isFloat(type)) {
            return Float.valueOf(stringValue);
        }
        if (TypeChecker.isDouble(type)) {
            return Double.valueOf(stringValue);
        }
        if (TypeChecker.isBool(type)) {
            return Boolean.valueOf(stringValue);
        }
        if (type == JavaType.STRING) {
            stringValue = StringUtils.removeStart(stringValue, "\"");
            stringValue = StringUtils.removeEnd(stringValue, "\"");
            return stringValue;
        }
        throw new AssertionError("Objects not yet implemented!");
    }
}
