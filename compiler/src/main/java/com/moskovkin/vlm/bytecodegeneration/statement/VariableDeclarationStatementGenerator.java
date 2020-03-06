package com.moskovkin.vlm.bytecodegeneration.statement;

import com.moskovkin.vlm.bytecodegeneration.expression.ExpressionGenerator;
import com.moskovkin.vlm.domain.expression.Expression;
import com.moskovkin.vlm.domain.statement.Assignment;
import com.moskovkin.vlm.domain.statement.VariableDeclaration;

public class VariableDeclarationStatementGenerator {
    private final StatementGenerator statementGenerator;
    private final ExpressionGenerator expressionGenerator;

    public VariableDeclarationStatementGenerator(StatementGenerator statementGenerator,
                                                 ExpressionGenerator expressionGenerator) {
        this.statementGenerator = statementGenerator;
        this.expressionGenerator = expressionGenerator;
    }

    public void generate(VariableDeclaration variableDeclaration) {
        Expression expression = variableDeclaration.getExpression();
        expression.accept(expressionGenerator);
        Assignment assignment = new Assignment(variableDeclaration);
        assignment.accept(statementGenerator);
    }
}