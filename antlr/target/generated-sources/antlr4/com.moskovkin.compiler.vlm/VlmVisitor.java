// Generated from com.moskovkin.compiler.vlm\Vlm.g4 by ANTLR 4.3
package com.moskovkin.compiler.vlm;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import com.moskovkin.compiler.vlm.VlmParser;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link VlmParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface VlmVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code Add}
	 * labeled alternative in {@link VlmParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdd(@NotNull com.moskovkin.compiler.vlm.VlmParser.AddContext ctx);

	/**
	 * Visit a parse tree produced by the {@code ReturnVoid}
	 * labeled alternative in {@link VlmParser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnVoid(@NotNull VlmParser.ReturnVoidContext ctx);

	/**
	 * Visit a parse tree produced by {@link VlmParser#variableReference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableReference(@NotNull VlmParser.VariableReferenceContext ctx);

	/**
	 * Visit a parse tree produced by {@link VlmParser#className}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassName(@NotNull VlmParser.ClassNameContext ctx);

	/**
	 * Visit a parse tree produced by {@link VlmParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(@NotNull VlmParser.TypeContext ctx);

	/**
	 * Visit a parse tree produced by {@link VlmParser#classDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDeclaration(@NotNull VlmParser.ClassDeclarationContext ctx);

	/**
	 * Visit a parse tree produced by the {@code Divide}
	 * labeled alternative in {@link VlmParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDivide(@NotNull VlmParser.DivideContext ctx);

	/**
	 * Visit a parse tree produced by the {@code VarReference}
	 * labeled alternative in {@link VlmParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarReference(@NotNull VlmParser.VarReferenceContext ctx);

	/**
	 * Visit a parse tree produced by the {@code ReturnWithValue}
	 * labeled alternative in {@link VlmParser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnWithValue(@NotNull VlmParser.ReturnWithValueContext ctx);

	/**
	 * Visit a parse tree produced by {@link VlmParser#function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(@NotNull VlmParser.FunctionContext ctx);

	/**
	 * Visit a parse tree produced by {@link VlmParser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter(@NotNull VlmParser.ParameterContext ctx);

	/**
	 * Visit a parse tree produced by the {@code Multiply}
	 * labeled alternative in {@link VlmParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiply(@NotNull VlmParser.MultiplyContext ctx);

	/**
	 * Visit a parse tree produced by {@link VlmParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(@NotNull VlmParser.StatementContext ctx);

	/**
	 * Visit a parse tree produced by {@link VlmParser#classBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassBody(@NotNull VlmParser.ClassBodyContext ctx);

	/**
	 * Visit a parse tree produced by {@link VlmParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(@NotNull VlmParser.BlockContext ctx);

	/**
	 * Visit a parse tree produced by {@link VlmParser#primitiveType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimitiveType(@NotNull VlmParser.PrimitiveTypeContext ctx);

	/**
	 * Visit a parse tree produced by {@link VlmParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(@NotNull VlmParser.ValueContext ctx);

	/**
	 * Visit a parse tree produced by the {@code ValueExpr}
	 * labeled alternative in {@link VlmParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueExpr(@NotNull VlmParser.ValueExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link VlmParser#functionName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionName(@NotNull VlmParser.FunctionNameContext ctx);

	/**
	 * Visit a parse tree produced by {@link VlmParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(@NotNull VlmParser.AssignmentContext ctx);

	/**
	 * Visit a parse tree produced by the {@code ConditionalExpression}
	 * labeled alternative in {@link VlmParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionalExpression(@NotNull VlmParser.ConditionalExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link VlmParser#variableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclaration(@NotNull VlmParser.VariableDeclarationContext ctx);

	/**
	 * Visit a parse tree produced by the {@code Substract}
	 * labeled alternative in {@link VlmParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubstract(@NotNull VlmParser.SubstractContext ctx);

	/**
	 * Visit a parse tree produced by {@link VlmParser#printStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintStatement(@NotNull VlmParser.PrintStatementContext ctx);

	/**
	 * Visit a parse tree produced by {@link VlmParser#compilationUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompilationUnit(@NotNull VlmParser.CompilationUnitContext ctx);

	/**
	 * Visit a parse tree produced by {@link VlmParser#field}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitField(@NotNull VlmParser.FieldContext ctx);

	/**
	 * Visit a parse tree produced by {@link VlmParser#name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitName(@NotNull VlmParser.NameContext ctx);

	/**
	 * Visit a parse tree produced by {@link VlmParser#parametersList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParametersList(@NotNull VlmParser.ParametersListContext ctx);

	/**
	 * Visit a parse tree produced by {@link VlmParser#functionDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDeclaration(@NotNull VlmParser.FunctionDeclarationContext ctx);

	/**
	 * Visit a parse tree produced by {@link VlmParser#classType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassType(@NotNull VlmParser.ClassTypeContext ctx);
}