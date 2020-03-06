package com.moskovkin.vlm.bytecodegeneration.statement;

import com.moskovkin.vlm.bytecodegeneration.expression.ExpressionGenerator;
import com.moskovkin.vlm.domain.ClassDeclaration;
import com.moskovkin.vlm.domain.Field;
import com.moskovkin.vlm.domain.expression.Expression;
import com.moskovkin.vlm.domain.statement.Assignment;
import com.moskovkin.vlm.domain.type.LocalVariable;
import com.moskovkin.vlm.domain.type.Type;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class AssignmentStatementGenerator {
    private final MethodVisitor methodVisitor;
    private final ExpressionGenerator expressionGenerator;
    private final ClassDeclaration classDeclaration;

    public AssignmentStatementGenerator(MethodVisitor methodVisitor, ExpressionGenerator expressionGenerator,
                                        ClassDeclaration classDeclaration) {
        this.methodVisitor = methodVisitor;
        this.expressionGenerator = expressionGenerator;
        this.classDeclaration = classDeclaration;
    }

    public void generate(Assignment assignment) {
        String varName = assignment.getVarName();
        Expression expression = assignment.getExpression();
        Type type = expression.getType();
        if (classDeclaration.isLocalVariableExists(varName)) {
            int index = classDeclaration.getLocalVariableIndex(varName);
            LocalVariable localVariable = classDeclaration.getLocalVariable(varName);
            Type localVariableType = localVariable.getType();
            castIfNecessary(type, localVariableType);
            methodVisitor.visitVarInsn(type.getStoreVariableOpcode(), index);
            return;
        }
        Field field = classDeclaration.getField(varName);
        String descriptor = field.getType().getDescriptor();
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 0);
        expression.accept(expressionGenerator);
        castIfNecessary(type, field.getType());
        methodVisitor.visitFieldInsn(Opcodes.PUTFIELD, field.getClassOwner(), field.getName(), descriptor);
    }

    private void castIfNecessary(Type expressionType, Type variableType) {
        if (!expressionType.equals(variableType)) {
            methodVisitor.visitTypeInsn(Opcodes.CHECKCAST, variableType.getInternalName());
        }
    }
}