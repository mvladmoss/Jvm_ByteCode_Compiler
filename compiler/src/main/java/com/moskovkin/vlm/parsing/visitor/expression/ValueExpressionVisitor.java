package com.moskovkin.vlm.parsing.visitor.expression;

import com.moskovkin.compiler.vlm.VlmParser;
import com.moskovkin.vlm.domain.expression.Value;
import com.moskovkin.vlm.domain.type.Type;
import com.moskovkin.vlm.util.TypeFactory;
import org.antlr.v4.runtime.misc.NotNull;

public class ValueExpressionVisitor extends com.moskovkin.compiler.vlm.VlmBaseVisitor<Value> {

    @Override
    public Value visitValue(@NotNull VlmParser.ValueContext ctx) {
        String value = ctx.getText();
        Type type = TypeFactory.getFromValue(ctx);
        return new Value(type, value);
    }
}