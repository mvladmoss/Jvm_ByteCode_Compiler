package com.moskovkin.vlm.domain.expression;

import com.moskovkin.vlm.bytecodegeneration.expression.ExpressionGenerator;
import com.moskovkin.vlm.bytecodegeneration.statement.StatementGenerator;
import com.moskovkin.vlm.domain.Statement;
import com.moskovkin.vlm.domain.type.Type;

public interface Expression extends Statement {
    Type getType();

    void accept(ExpressionGenerator genrator);

    @Override
    void accept(StatementGenerator generator);
}
