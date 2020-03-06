package com.moskovkin.vlm.bytecodegeneration.expression;

import com.moskovkin.vlm.domain.ClassDeclaration;
import com.moskovkin.vlm.domain.expression.FieldReference;
import com.moskovkin.vlm.domain.expression.LocalVariableReference;
import com.moskovkin.vlm.domain.type.Type;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class ReferenceExpressionGenerator {
    private final MethodVisitor methodVisitor;
    private final ClassDeclaration classDeclaration;

    public ReferenceExpressionGenerator(MethodVisitor methodVisitor, ClassDeclaration classDeclaration) {
        this.methodVisitor = methodVisitor;
        this.classDeclaration = classDeclaration;
    }

    public void generate(LocalVariableReference localVariableReference) {
        String varName = localVariableReference.geName();
        int index = classDeclaration.getLocalVariableIndex(varName);
        Type type = localVariableReference.getType();
        methodVisitor.visitVarInsn(type.getLoadVariableOpcode(), index);
    }

    public void generate(FieldReference fieldReference) {
        String varName = fieldReference.geName();
        Type type = fieldReference.getType();
        String ownerInternalName = fieldReference.getOwnerInternalName();
        String descriptor = type.getDescriptor();
        methodVisitor.visitVarInsn(Opcodes.ALOAD,0);
        methodVisitor.visitFieldInsn(Opcodes.GETFIELD, ownerInternalName,varName,descriptor);
    }
}