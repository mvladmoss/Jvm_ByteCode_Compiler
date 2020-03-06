package com.moskovkin.vlm.domain.statement;

import com.moskovkin.vlm.bytecodegeneration.statement.StatementGenerator;
import com.moskovkin.vlm.domain.Statement;
import com.moskovkin.vlm.domain.expression.Expression;

public class PrintStatement implements Statement {

    private final Expression expression;

    public PrintStatement(Expression expression) {
        this.expression = expression;
    }

    public Expression getExpression() {
        return expression;
    }

    @Override
    public void accept(StatementGenerator generator) {
        generator.generate(this);
    }
}
