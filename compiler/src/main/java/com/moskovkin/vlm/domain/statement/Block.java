package com.moskovkin.vlm.domain.statement;

import java.util.Collections;
import java.util.List;

import com.moskovkin.vlm.bytecodegeneration.statement.StatementGenerator;
import com.moskovkin.vlm.domain.ClassDeclaration;
import com.moskovkin.vlm.domain.Statement;

public class Block implements Statement {
    private final List<Statement> statements;
    private final ClassDeclaration classDeclaration;

    public Block(ClassDeclaration classDeclaration, List<Statement> statements) {
        this.classDeclaration = classDeclaration;
        this.statements = statements;
    }

    public static Block empty(ClassDeclaration classDeclaration) {
        return new Block(classDeclaration, Collections.emptyList());
    }

    @Override
    public void accept(StatementGenerator generator) {
        generator.generate(this);
    }

    public ClassDeclaration getScope() {
        return classDeclaration;
    }

    public List<Statement> getStatements() {
        return Collections.unmodifiableList(statements);
    }
}
