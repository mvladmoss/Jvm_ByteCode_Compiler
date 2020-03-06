package com.moskovkin.vlm.parsing;

import com.moskovkin.compiler.vlm.VlmBaseVisitor;
import com.moskovkin.compiler.vlm.VlmParser.ClassDeclarationContext;
import com.moskovkin.vlm.domain.ClassDeclaration;
import com.moskovkin.vlm.domain.CompilationUnit;

public class CompilationUnitVisitor extends VlmBaseVisitor<CompilationUnit> {

    @Override
    public CompilationUnit visitCompilationUnit(com.moskovkin.compiler.vlm.VlmParser.CompilationUnitContext ctx) {
        ClassVisitor classVisitor = new ClassVisitor();
        ClassDeclarationContext classDeclarationContext = ctx.classDeclaration();
        ClassDeclaration classDeclaration = classDeclarationContext.accept(classVisitor);
        return super.visitCompilationUnit(ctx);
    }
}
