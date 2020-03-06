package com.moskovkin.vlm.parsing.visitor;

import java.util.Collections;
import java.util.List;

import com.moskovkin.compiler.vlm.VlmBaseVisitor;
import com.moskovkin.compiler.vlm.VlmParser.ParametersListContext;
import com.moskovkin.vlm.domain.ClassDeclaration;
import com.moskovkin.vlm.domain.Function;
import com.moskovkin.vlm.domain.Parameter;
import com.moskovkin.vlm.domain.type.Type;
import com.moskovkin.vlm.parsing.visitor.expression.ExpressionVisitor;
import com.moskovkin.vlm.util.TypeFactory;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import static com.moskovkin.compiler.vlm.VlmParser.FunctionDeclarationContext;

@Data
@RequiredArgsConstructor
public class FunctionVisitor extends VlmBaseVisitor<Function> {

    private final ExpressionVisitor expressionVisitor;

    public FunctionVisitor(ClassDeclaration classDeclaration) {
        this.expressionVisitor = new ExpressionVisitor(classDeclaration);
    }

    @Override
    public Function visitFunctionDeclaration(FunctionDeclarationContext ctx) {
        String funcName = ctx.functionName().getText();
        Type returnType = TypeFactory.createType(ctx.type());
        ParametersListContext parametersCtx = ctx.parametersList();
        if(parametersCtx != null) {
            List<Parameter> parameters = parametersCtx.accept(new ParameterExpressionListVisitor(expressionVisitor));
            return new Function(funcName, parameters, returnType);
        }
        return new Function(funcName, Collections.emptyList(), returnType);
    }

}
