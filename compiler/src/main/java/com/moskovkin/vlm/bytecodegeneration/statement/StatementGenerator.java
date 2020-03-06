package com.moskovkin.vlm.bytecodegeneration.statement;

import com.moskovkin.vlm.bytecodegeneration.expression.ExpressionGenerator;
import com.moskovkin.vlm.domain.ClassDeclaration;
import com.moskovkin.vlm.domain.Parameter;
import com.moskovkin.vlm.domain.expression.ConstructorCall;
import com.moskovkin.vlm.domain.expression.FieldReference;
import com.moskovkin.vlm.domain.expression.FunctionCall;
import com.moskovkin.vlm.domain.expression.LocalVariableReference;
import com.moskovkin.vlm.domain.expression.Value;
import com.moskovkin.vlm.domain.expression.arthimetic.Addition;
import com.moskovkin.vlm.domain.expression.arthimetic.Division;
import com.moskovkin.vlm.domain.expression.arthimetic.Multiplication;
import com.moskovkin.vlm.domain.expression.arthimetic.Substraction;
import com.moskovkin.vlm.domain.statement.Assignment;
import com.moskovkin.vlm.domain.statement.Block;
import com.moskovkin.vlm.domain.statement.PrintStatement;
import com.moskovkin.vlm.domain.statement.ReturnStatement;
import com.moskovkin.vlm.domain.statement.VariableDeclaration;
import org.objectweb.asm.MethodVisitor;

public class StatementGenerator {

    private final PrintStatementGenerator printStatementGenerator;
    private final VariableDeclarationStatementGenerator variableDeclarationStatementGenerator;
    private final ReturnStatemenetGenerator returnStatemenetGenerator;
//    private final IfStatementGenerator ifStatementGenerator;
    private final BlockStatementGenerator blockStatementGenerator;
//    private final ForStatementGenerator forStatementGenerator;
    private final AssignmentStatementGenerator assignmentStatementGenerator;
    private final ExpressionGenerator expressionGenerator;

    public StatementGenerator(MethodVisitor methodVisitor, ClassDeclaration scope) {
        expressionGenerator = new ExpressionGenerator(methodVisitor, scope);
        printStatementGenerator = new PrintStatementGenerator(expressionGenerator,methodVisitor);
        variableDeclarationStatementGenerator = new VariableDeclarationStatementGenerator(this, expressionGenerator);
//        forStatementGenerator = new ForStatementGenerator(methodVisitor);
        blockStatementGenerator = new BlockStatementGenerator(methodVisitor);
//        ifStatementGenerator = new IfStatementGenerator(this, expressionGenerator, methodVisitor);
        returnStatemenetGenerator = new ReturnStatemenetGenerator(expressionGenerator, methodVisitor);
        assignmentStatementGenerator = new AssignmentStatementGenerator(methodVisitor, expressionGenerator,scope);
    }

    public void generate(PrintStatement printStatement) {
        printStatementGenerator.generate(printStatement);
    }

    public void generate(VariableDeclaration variableDeclaration) {
        variableDeclarationStatementGenerator.generate(variableDeclaration);
    }

    public void generate(FunctionCall functionCall) {
        functionCall.accept(expressionGenerator);
    }

    public void generate(ReturnStatement returnStatement) {
        returnStatemenetGenerator.generate(returnStatement);
    }

//    public void generate(IfStatement ifStatement) {
//        ifStatementGenerator.generate(ifStatement);
//    }

    public void generate(Block block) {
        blockStatementGenerator.generate(block);
    }

//    public void generate(RangedForStatement rangedForStatement) {
//        forStatementGenerator.generate(rangedForStatement);
//    }

    public void generate(Assignment assignment) {
        assignmentStatementGenerator.generate(assignment);
    }

//    public void generate(SuperCall superCall) {
//        expressionGenerator.generate(superCall);
//    }

    public void generate(ConstructorCall constructorCall) {
        expressionGenerator.generate(constructorCall);
    }

    public void generate(Addition addition) {
        expressionGenerator.generate(addition);
    }

    public void generate(Parameter parameter) {
        expressionGenerator.generate(parameter);
    }

//    public void generate(ConditionalExpression conditionalExpression) {
//        expressionGenerator.generate(conditionalExpression);
//    }

    public void generate(Multiplication multiplication) {
        expressionGenerator.generate(multiplication);
    }

    public void generate(Value value) {
        expressionGenerator.generate(value);
    }

    public void generate(Substraction substraction) {
        expressionGenerator.generate(substraction);
    }

    public void generate(Division division) {
        expressionGenerator.generate(division);
    }

//    public void generate(EmptyExpression emptyExpression) {
//        expressionGenerator.generate(emptyExpression);
//    }

    public void generate(LocalVariableReference localVariableReference) {
        expressionGenerator.generate(localVariableReference);
    }

    public void generate(FieldReference fieldReference) {
        expressionGenerator.generate(fieldReference);
    }
}
