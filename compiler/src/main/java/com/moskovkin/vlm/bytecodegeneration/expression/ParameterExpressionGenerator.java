package com.moskovkin.vlm.bytecodegeneration.expression;

import com.moskovkin.vlm.domain.ClassDeclaration;
import com.moskovkin.vlm.domain.Parameter;
import com.moskovkin.vlm.domain.type.Type;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.objectweb.asm.MethodVisitor;

@Data
@RequiredArgsConstructor
public class ParameterExpressionGenerator {
    private final MethodVisitor methodVisitor;
    private final ClassDeclaration classDeclaration;

    public void generate(Parameter parameter) {
        Type type = parameter.getType();
        int index = classDeclaration.getLocalVariableIndex(parameter.getName());
        methodVisitor.visitVarInsn(type.getLoadVariableOpcode(), index);
    }
}