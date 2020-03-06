package com.moskovkin.vlm.domain.statement;


import com.moskovkin.vlm.bytecodegeneration.statement.StatementGenerator;
import com.moskovkin.vlm.domain.Statement;
import com.moskovkin.vlm.domain.expression.Expression;

public class VariableDeclaration implements Statement {
    private final String name;
    private final Expression expression;

    public VariableDeclaration(String name, Expression expression) {
        this.expression = expression;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Expression getExpression() {
        return expression;
    }

    @Override
    public void accept(StatementGenerator generator) {
        generator.generate(this);
    }
}
