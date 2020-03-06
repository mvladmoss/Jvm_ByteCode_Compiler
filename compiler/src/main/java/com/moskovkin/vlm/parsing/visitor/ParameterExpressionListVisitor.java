package com.moskovkin.vlm.parsing.visitor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.moskovkin.compiler.vlm.VlmParser;
import com.moskovkin.vlm.domain.Parameter;
import com.moskovkin.vlm.parsing.visitor.expression.ExpressionVisitor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;
import com.moskovkin.compiler.vlm.VlmBaseVisitor;

/**
 * Created by kuba on 09.05.16.
 */
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class ParameterExpressionListVisitor extends VlmBaseVisitor<List<Parameter>> {

    private final ExpressionVisitor expressionVisitor;

    @Override
    public List<Parameter> visitParametersList(@NotNull VlmParser.ParametersListContext ctx) {
        List<VlmParser.ParameterContext> paramsCtx = ctx.parameter();
        ParameterExpressionVisitor parameterExpressionVisitor = new ParameterExpressionVisitor(expressionVisitor);
        List<Parameter> parameters = new ArrayList<>();
        if (paramsCtx != null) {
            List<Parameter> params =
                    paramsCtx.stream()
                            .map(p -> p.accept(parameterExpressionVisitor))
                            .collect(Collectors.toList());
            parameters.addAll(params);
        }

        return parameters;
    }
}

