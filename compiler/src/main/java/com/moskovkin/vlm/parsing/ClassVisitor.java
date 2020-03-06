package com.moskovkin.vlm.parsing;

import java.util.Collections;
import java.util.List;

import com.moskovkin.compiler.vlm.VlmParser;
import com.moskovkin.vlm.domain.ClassDeclaration;
import com.moskovkin.compiler.vlm.VlmBaseVisitor;
import com.moskovkin.vlm.domain.Field;
import com.moskovkin.vlm.domain.Function;
import com.moskovkin.vlm.domain.type.JavaType;
import com.moskovkin.vlm.parsing.visitor.FunctionVisitor;

import static java.util.stream.Collectors.toList;

public class ClassVisitor extends VlmBaseVisitor<ClassDeclaration> {

    @Override
    public ClassDeclaration visitClassDeclaration(VlmParser.ClassDeclarationContext ctx) {
        String className = ctx.className().getText();
        ClassDeclaration classDeclaration = new ClassDeclaration(className, "java.lang.Object");
        FieldVisitor fieldVisitor = new FieldVisitor(classDeclaration);
        FunctionVisitor functionVisitor = new FunctionVisitor(classDeclaration);
        List<VlmParser.FunctionContext> methodsCtx = ctx.classBody().function();
        List<Field> fields = ctx.classBody().field().stream()
                .map(field -> field.accept(fieldVisitor))
                .peek(classDeclaration::addField)
                .collect(toList());
        methodsCtx.stream()
                .map(method -> method.functionDeclaration().accept(functionVisitor))
                .forEach(classDeclaration::addFunction);
        boolean defaultConstructorExists = classDeclaration.isFunctionExists(className, Collections.emptyList());
        if (!defaultConstructorExists) {
                Function constructorSignature = new Function(className, Collections.emptyList(),
                        JavaType.VOID);
                classDeclaration.addFunction(constructorSignature);
        }

        boolean startMethodDefined = scope.isParameterLessSignatureExists("start");
        if (startMethodDefined) {
            methods.add(getGeneratedMainMethod());
        }
    }
}
