package com.moskovkin.vlm.domain.expression;

import java.util.Collections;
import java.util.List;

import com.moskovkin.vlm.bytecodegeneration.expression.ExpressionGenerator;
import com.moskovkin.vlm.bytecodegeneration.statement.StatementGenerator;
import com.moskovkin.vlm.domain.Function;
import com.moskovkin.vlm.domain.type.Type;

public class FunctionCall implements Call {
    private final String owner;
    private final Function function;
    private final List<Argument> arguments;
    private final Type type;

    public FunctionCall(Function function, List<Argument> arguments, String owner) {
        this.type = function.getType();
        this.function = function;
        this.arguments = arguments;
        this.owner = owner;
    }


    @Override
    public List<Argument> getArguments() {
        return Collections.unmodifiableList(arguments);
    }

    @Override
    public String getIdentifier() {
        return function.getName();
    }

    public String getOwner() {
        return owner;
    }

    public Function getFunction() {
        return function;
    }

    @Override
    public void accept(ExpressionGenerator genrator) {
        genrator.generate(this);
    }

    @Override
    public void accept(StatementGenerator generator) {
        generator.generate(this);
    }

    @Override
    public Type getType() {
        return type;
    }
}
