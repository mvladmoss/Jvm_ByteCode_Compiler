package com.moskovkin.vlm.domain.expression;

import java.util.Optional;

import com.moskovkin.vlm.bytecodegeneration.expression.ExpressionGenerator;
import com.moskovkin.vlm.bytecodegeneration.statement.StatementGenerator;
import com.moskovkin.vlm.domain.type.Type;

public class Argument implements Expression {

    private final Optional<String> parameterName;
    private final Expression expression;

    public Argument(Expression expression, Optional<String> parameterName) {
        this.parameterName = parameterName;
        this.expression = expression;
    }

    @Override
    public Type getType() {
        return expression.getType();
    }

    @Override
    public void accept(ExpressionGenerator genrator) {
        expression.accept(genrator);
    }

    @Override
    public void accept(StatementGenerator generator) {
        expression.accept(generator);
    }

    public Optional<String> getParameterName() {
        return parameterName;
    }
}
