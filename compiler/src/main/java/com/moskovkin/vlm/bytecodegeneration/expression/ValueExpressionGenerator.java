package com.moskovkin.vlm.bytecodegeneration.expression;

import com.moskovkin.vlm.domain.expression.Value;
import com.moskovkin.vlm.domain.type.Type;
import com.moskovkin.vlm.util.TypeFactory;
import org.objectweb.asm.MethodVisitor;

public class ValueExpressionGenerator {
    private final MethodVisitor methodVisitor;

    public ValueExpressionGenerator(MethodVisitor methodVisitor) {
        this.methodVisitor = methodVisitor;
    }

    public void generate(Value value) {
        Type type = value.getType();
        String stringValue = value.getValue();
        Object transformedValue = TypeFactory.getValueFromString(stringValue, type);
        methodVisitor.visitLdcInsn(transformedValue);
    }
}