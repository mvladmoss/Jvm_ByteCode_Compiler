package com.moskovkin.vlm.domain.expression;

import com.moskovkin.vlm.bytecodegeneration.expression.ExpressionGenerator;
import com.moskovkin.vlm.bytecodegeneration.statement.StatementGenerator;
import com.moskovkin.vlm.domain.type.LocalVariable;
import com.moskovkin.vlm.domain.type.Type;

/**
 * Created by kuba on 09.04.16.
 */
public class LocalVariableReference implements Reference {

    private final LocalVariable variable;

    public LocalVariableReference(LocalVariable variable) {
        this.variable = variable;
    }

    @Override
    public String geName() {
        return variable.getName();
    }

    @Override
    public void accept(ExpressionGenerator generator) {
        generator.generate(this);
    }

    @Override
    public Type getType() {
        return variable.getType();
    }

    @Override
    public void accept(StatementGenerator generator) {
        generator.generate(this);
    }
}
