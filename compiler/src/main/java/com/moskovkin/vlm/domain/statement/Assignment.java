package com.moskovkin.vlm.domain.statement;

import com.moskovkin.vlm.bytecodegeneration.statement.StatementGenerator;
import com.moskovkin.vlm.domain.Statement;
import com.moskovkin.vlm.domain.expression.Expression;
import lombok.Data;

@Data
public class Assignment implements Statement {
    private final String varName;
    private final Expression expression;

    public Assignment(String varName, Expression expression) {
        this.varName = varName;
        this.expression = expression;
    }

    public Assignment(VariableDeclaration declarationStatement) {
        this.varName = declarationStatement.getName();
        this.expression = declarationStatement.getExpression();
    }

    @Override
    public void accept(StatementGenerator generator) {
        generator.generate(this);
    }
}
