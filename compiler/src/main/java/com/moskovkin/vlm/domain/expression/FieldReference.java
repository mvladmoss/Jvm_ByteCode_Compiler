package com.moskovkin.vlm.domain.expression;

import com.moskovkin.vlm.bytecodegeneration.expression.ExpressionGenerator;
import com.moskovkin.vlm.bytecodegeneration.statement.StatementGenerator;
import com.moskovkin.vlm.domain.Field;
import com.moskovkin.vlm.domain.type.Type;

public class FieldReference implements Reference {
    private Field field;

    public FieldReference(Field field) {
        this.field = field;
    }

    @Override
    public String geName() {
        return field.getName();
    }

    @Override
    public void accept(ExpressionGenerator generator) {
        generator.generate(this);
    }

    @Override
    public Type getType() {
        return field.getType();
    }

    @Override
    public void accept(StatementGenerator generator) {
        generator.generate(this);
    }

    public String getOwnerInternalName() {
        return field.getType().getInternalName();
    }
}
