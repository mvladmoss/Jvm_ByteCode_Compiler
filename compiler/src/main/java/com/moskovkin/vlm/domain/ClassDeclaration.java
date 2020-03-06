package com.moskovkin.vlm.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.moskovkin.vlm.domain.type.LocalVariable;
import io.vavr.Tuple3;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class ClassDeclaration {

    private String className;
    private String superClassName;
    private List<Function> functions;
    private Map<String, Field> fields;
    private List<Tuple3<Integer, String, LocalVariable>> localVariables;

    public ClassDeclaration(String className, String superClassName) {
        this.className = className;
        this.superClassName = superClassName;
    }

    public int getLocalVariableIndex(String varName) {
        return localVariables.stream()
                .filter(tuple -> tuple._2.equals(varName))
                .map(tuple -> tuple._1)
                .collect(Collectors.toList())
                .get(0);
    }

    public boolean isLocalVariableExists(String varName) {
        return localVariables.stream()
                .anyMatch(tuple -> tuple._2.equals(varName));
    }

    public boolean isFieldExists(String fieldName) {
        return fields.containsKey(fieldName);
    }

    public LocalVariable getLocalVariable(String varName) {
        return localVariables.stream()
                .filter(tuple -> tuple._2.equals(varName))
                .map(tuple -> tuple._3)
                .findAny()
                .orElseThrow(() -> new RuntimeException("There is no such local variable")); //TODO: custom exception
    }

    public Field getField(String fieldName) {
        return fields.get(fieldName);
    }

    public void addField(Field field) {
        this.fields.put(field.getName(), field);
    }

    public void addFunction(Function function) {
        if (isFunctionExists(function.getName(), function.getParameters())) {
            throw new RuntimeException("Method with such name and signature has already exist");//TODO:
        }
        functions.add(function);
    }

    public boolean isFunctionExists(String identifier, List<Parameter> parameters) {
        return functions.stream()
                .anyMatch(function -> function.isFucntionMatch(identifier, parameters));
    }
}
