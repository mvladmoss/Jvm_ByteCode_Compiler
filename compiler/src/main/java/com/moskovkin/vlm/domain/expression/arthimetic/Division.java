package com.moskovkin.vlm.domain.expression.arthimetic;

import com.moskovkin.vlm.bytecodegeneration.expression.ExpressionGenerator;
import com.moskovkin.vlm.bytecodegeneration.statement.StatementGenerator;
import com.moskovkin.vlm.domain.expression.Expression;

public class Division extends ArthimeticExpression {
    public Division(Expression leftExpress, Expression rightExpress) {
        super(leftExpress, rightExpress);
    }

    @Override
    public void accept(ExpressionGenerator genrator) {
        genrator.generate(this);
    }

    @Override
    public void accept(StatementGenerator generator) {
        generator.generate(this);
    }
}
