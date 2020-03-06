package com.moskovkin.vlm.parsing;

import com.moskovkin.vlm.domain.ClassDeclaration;
import com.moskovkin.vlm.domain.Field;
import com.moskovkin.vlm.domain.type.Type;
import com.moskovkin.vlm.util.TypeFactory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;
import com.moskovkin.compiler.vlm.VlmBaseVisitor;

import static com.moskovkin.compiler.vlm.VlmParser.*;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class FieldVisitor extends VlmBaseVisitor<Field> {

    private final ClassDeclaration classDeclaration;

    @Override
    public Field visitField(@NotNull FieldContext ctx) {
        String owner = classDeclaration.getClassName();
        Type type = TypeFactory.createType(ctx.type());
        String name = ctx.name().getText();
        return new Field(name, owner, type);
    }
}
