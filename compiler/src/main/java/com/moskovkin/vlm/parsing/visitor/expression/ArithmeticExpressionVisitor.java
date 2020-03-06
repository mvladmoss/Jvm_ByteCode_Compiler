package com.moskovkin.vlm.parsing.visitor.expression;

import com.moskovkin.compiler.vlm.VlmBaseVisitor;
import com.moskovkin.compiler.vlm.VlmParser;
import com.moskovkin.compiler.vlm.VlmParser.DivideContext;
import com.moskovkin.compiler.vlm.VlmParser.ExpressionContext;
import com.moskovkin.compiler.vlm.VlmParser.MultiplyContext;
import com.moskovkin.compiler.vlm.VlmParser.SubstractContext;
import com.moskovkin.vlm.domain.expression.Expression;
import com.moskovkin.vlm.domain.expression.arthimetic.Addition;
import com.moskovkin.vlm.domain.expression.arthimetic.ArthimeticExpression;
import com.moskovkin.vlm.domain.expression.arthimetic.Division;
import com.moskovkin.vlm.domain.expression.arthimetic.Multiplication;
import com.moskovkin.vlm.domain.expression.arthimetic.Substraction;
import org.antlr.v4.runtime.misc.NotNull;

public class ArithmeticExpressionVisitor extends VlmBaseVisitor<ArthimeticExpression> {
    private final ExpressionVisitor expressionVisitor;

    public ArithmeticExpressionVisitor(ExpressionVisitor expressionVisitor) {
        this.expressionVisitor = expressionVisitor;
    }

    @Override
    public ArthimeticExpression visitAdd(@NotNull VlmParser.AddContext ctx) {
        ExpressionContext leftExpression = ctx.expression(0);
        ExpressionContext rightExpression = ctx.expression(1);
        Expression leftExpress = leftExpression.accept(expressionVisitor);
        Expression rightExpress = rightExpression.accept(expressionVisitor);

        return new Addition(leftExpress, rightExpress);
    }

    @Override
    public ArthimeticExpression visitMultiply(@NotNull MultiplyContext ctx) {
        ExpressionContext leftExpression = ctx.expression(0);
        ExpressionContext rightExpression = ctx.expression(1);

        Expression leftExpress = leftExpression.accept(expressionVisitor);
        Expression rightExpress = rightExpression.accept(expressionVisitor);

        return new Multiplication(leftExpress, rightExpress);
    }

    @Override
    public ArthimeticExpression visitSubstract(@NotNull SubstractContext ctx) {
        ExpressionContext leftExpression = ctx.expression(0);
        ExpressionContext rightExpression = ctx.expression(1);

        Expression leftExpress = leftExpression.accept(expressionVisitor);
        Expression rightExpress = rightExpression.accept(expressionVisitor);

        return new Substraction(leftExpress, rightExpress);
    }

    @Override
    public ArthimeticExpression visitDivide(@NotNull DivideContext ctx) {
        ExpressionContext leftExpression = ctx.expression(0);
        ExpressionContext rightExpression = ctx.expression(1);

        Expression leftExpress = leftExpression.accept(expressionVisitor);
        Expression rightExpress = rightExpression.accept(expressionVisitor);

        return new Division(leftExpress, rightExpress);
    }
}