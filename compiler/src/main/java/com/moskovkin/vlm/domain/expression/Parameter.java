package com.moskovkin.vlm.domain.expression;

import java.util.Optional;

import com.moskovkin.vlm.bytecodegeneration.expression.ExpressionGenerator;
import com.moskovkin.vlm.bytecodegeneration.statement.StatementGenerator;
import com.moskovkin.vlm.domain.type.Type;
import lombok.ToString;

@ToString
public class Parameter implements Expression {
    private final String name;
    private final Optional<Expression> defaultValue;
    private final Type type;

    public Parameter(String name, Type type, Optional<Expression> defaultValue) {
        this.type = type;
        this.name = name;
        this.defaultValue = defaultValue;
    }

    public String getName() {
        return name;
    }

    public Optional<Expression> getDefaultValue() {
        return defaultValue;
    }

    @Override
    public void accept(ExpressionGenerator generator) {
        generator.generate(this);
    }

    @Override
    public void accept(StatementGenerator generator) {
        generator.generate(this);
    }

    @Override
    public Type getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Parameter parameter = (Parameter) o;

        if (defaultValue != null ? !defaultValue.equals(parameter.defaultValue) : parameter.defaultValue != null)
            return false;
        return !(type != null ? !type.equals(parameter.type) : parameter.type != null);

    }

    @Override
    public int hashCode() {
        int result = defaultValue != null ? defaultValue.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }


}
