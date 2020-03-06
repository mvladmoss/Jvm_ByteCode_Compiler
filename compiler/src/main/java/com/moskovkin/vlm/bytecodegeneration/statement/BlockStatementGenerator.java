package com.moskovkin.vlm.bytecodegeneration.statement;

import java.util.List;

import com.moskovkin.vlm.domain.ClassDeclaration;
import com.moskovkin.vlm.domain.Statement;
import com.moskovkin.vlm.domain.statement.Block;
import org.objectweb.asm.MethodVisitor;

public class BlockStatementGenerator {
    private final MethodVisitor methodVisitor;

    public BlockStatementGenerator(MethodVisitor methodVisitor) {
        this.methodVisitor = methodVisitor;
    }

    public void generate(Block block) {
        ClassDeclaration newScope = block.getScope();
        List<Statement> statements = block.getStatements();
        StatementGenerator statementGenerator = new StatementGenerator(methodVisitor, newScope);
        statements.forEach(stmt -> stmt.accept(statementGenerator));
    }
}