package com.moskovkin.vlm.domain.expression;

import com.moskovkin.vlm.bytecodegeneration.expression.ExpressionGenerator;
import com.moskovkin.vlm.bytecodegeneration.statement.StatementGenerator;

public interface Reference extends Expression {
    String geName();

    @Override
    void accept(ExpressionGenerator genrator);

    @Override
    void accept(StatementGenerator generator);
}
