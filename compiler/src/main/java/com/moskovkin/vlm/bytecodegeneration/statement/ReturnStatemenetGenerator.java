package com.moskovkin.vlm.bytecodegeneration.statement;

import com.moskovkin.vlm.bytecodegeneration.expression.ExpressionGenerator;
import com.moskovkin.vlm.domain.expression.Expression;
import com.moskovkin.vlm.domain.statement.ReturnStatement;
import com.moskovkin.vlm.domain.type.Type;
import org.objectweb.asm.MethodVisitor;

public class ReturnStatemenetGenerator {
    private final ExpressionGenerator expressionGenerator;
    private final MethodVisitor methodVisitor;

    public ReturnStatemenetGenerator(ExpressionGenerator expressionGenerator, MethodVisitor methodVisitor) {
        this.expressionGenerator = expressionGenerator;
        this.methodVisitor = methodVisitor;
    }

    public void generate(ReturnStatement returnStatement) {
        Expression expression = returnStatement.getExpression();
        Type type = expression.getType();
        expression.accept(expressionGenerator);
        methodVisitor.visitInsn(type.getReturnOpcode());
    }
}