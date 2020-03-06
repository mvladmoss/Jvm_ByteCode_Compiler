package com.moskovkin.vlm.parsing.visitor.expression;

import com.moskovkin.compiler.vlm.VlmParser;
import com.moskovkin.vlm.domain.ClassDeclaration;
import com.moskovkin.vlm.domain.expression.Expression;
import com.moskovkin.compiler.vlm.VlmBaseVisitor;
import org.antlr.v4.runtime.misc.NotNull;

public class ExpressionVisitor extends VlmBaseVisitor<Expression> {

    private final ArithmeticExpressionVisitor arithmeticExpressionVisitor;
    private final VariableReferenceExpressionVisitor variableReferenceExpressionVisitor;
    private final ValueExpressionVisitor valueExpressionVisitor;
//    private final CallExpressionVisitor callExpressionVisitor;
//    private final ConditionalExpressionVisitor conditionalExpressionVisitor;

    public ExpressionVisitor(ClassDeclaration scope) {
        arithmeticExpressionVisitor = new ArithmeticExpressionVisitor(this);
        variableReferenceExpressionVisitor = new VariableReferenceExpressionVisitor(scope);
        valueExpressionVisitor = new ValueExpressionVisitor();
//        callExpressionVisitor = new CallExpressionVisitor(this, scope);
//        conditionalExpressionVisitor = new ConditionalExpressionVisitor(this);
    }

    @Override
    public Expression visitVarReference(@NotNull VlmParser.VarReferenceContext ctx) {
        return variableReferenceExpressionVisitor.visitVarReference(ctx);
    }

    @Override
    public Expression visitValue(@NotNull VlmParser.ValueContext ctx) {
        return valueExpressionVisitor.visitValue(ctx);
    }

//    @Override
//    public Expression visitFunctionCall(@NotNull FunctionCallContext ctx) {
//        return callExpressionVisitor.visitFunctionCall(ctx);
//    }

//    @Override
//    public Expression visitConstructorCall(@NotNull ConstructorCallContext ctx) {
//        return callExpressionVisitor.visitConstructorCall(ctx);
//    }

//    @Override
//    public Expression visitSupercall(@NotNull SupercallContext ctx) {
//        return callExpressionVisitor.visitSupercall(ctx);
//    }

    @Override
    public Expression visitAdd(@NotNull VlmParser.AddContext ctx) {
        return arithmeticExpressionVisitor.visitAdd(ctx);
    }

    @Override
    public Expression visitMultiply(@NotNull VlmParser.MultiplyContext ctx) {

        return arithmeticExpressionVisitor.visitMultiply(ctx);
    }

    @Override
    public Expression visitSubstract(@NotNull VlmParser.SubstractContext ctx) {

        return arithmeticExpressionVisitor.visitSubstract(ctx);
    }

    @Override
    public Expression visitDivide(@NotNull VlmParser.DivideContext ctx) {

        return arithmeticExpressionVisitor.visitDivide(ctx);
    }

//    @Override
//    public ConditionalExpression visitConditionalExpression(@NotNull ConditionalExpressionContext ctx) {
//        return conditionalExpressionVisitor.visitConditionalExpression(ctx);
//    }
}
