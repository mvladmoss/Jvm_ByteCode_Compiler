package com.moskovkin.vlm.parsing.visitor;


import com.moskovkin.compiler.vlm.VlmBaseVisitor;
import com.moskovkin.compiler.vlm.VlmParser;
import com.moskovkin.vlm.domain.Parameter;
import com.moskovkin.vlm.domain.type.Type;
import com.moskovkin.vlm.parsing.visitor.expression.ExpressionVisitor;
import com.moskovkin.vlm.util.TypeFactory;

public class ParameterExpressionVisitor extends VlmBaseVisitor<Parameter> {

    private final ExpressionVisitor expressionVisitor;

    public ParameterExpressionVisitor(ExpressionVisitor expressionVisitor) {
        this.expressionVisitor = expressionVisitor;
    }

    @Override
    public Parameter visitParameter(VlmParser.ParameterContext ctx) {
        String name = ctx.ID().getText();
        Type type = TypeFactory.createType(ctx.type());
        return new Parameter(name, type);

    }
}
