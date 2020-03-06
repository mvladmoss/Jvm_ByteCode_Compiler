package com.moskovkin.vlm.parsing.visitor.expression;

import com.moskovkin.compiler.vlm.VlmParser;
import com.moskovkin.vlm.domain.ClassDeclaration;
import com.moskovkin.vlm.domain.Field;
import com.moskovkin.vlm.domain.expression.FieldReference;
import com.moskovkin.vlm.domain.expression.LocalVariableReference;
import com.moskovkin.vlm.domain.expression.Reference;
import com.moskovkin.vlm.domain.type.LocalVariable;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;
import com.moskovkin.compiler.vlm.VlmBaseVisitor;

@Data
@RequiredArgsConstructor
public class VariableReferenceExpressionVisitor extends VlmBaseVisitor<Reference> {

    private final ClassDeclaration classDeclaration;

    @Override
    public Reference visitVarReference(@NotNull VlmParser.VarReferenceContext ctx) {
        String varName = ctx.getText();
        if(classDeclaration.isFieldExists(varName)) {
            Field field = classDeclaration.getField(varName);
            return new FieldReference(field);
        }
        LocalVariable variable = classDeclaration.getLocalVariable(varName);
        return new LocalVariableReference(variable);
    }
}