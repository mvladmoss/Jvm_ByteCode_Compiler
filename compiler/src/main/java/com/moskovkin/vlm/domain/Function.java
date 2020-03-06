package com.moskovkin.vlm.domain;

import java.util.List;
import java.util.stream.IntStream;

import com.moskovkin.vlm.domain.type.Type;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Function {

    private final String name;
    private final List<Parameter> parameters;
    private final Type type;

    public boolean isFucntionMatch(String otherFunctionName, List<Parameter> parameters) {
        boolean namesAreEqual = this.name.equals(otherFunctionName);
        if (!namesAreEqual) {
            return false;
        }
        if (parameters.size() > this.parameters.size()) {
            return false;
        }
        return areArgumentsAndParamsMatchedByIndex(parameters);
    }

    private boolean areArgumentsAndParamsMatchedByIndex(List<Parameter> parameters) {
        return IntStream.range(0, parameters.size())
                .allMatch(i -> {
                    Type argumentType = parameters.get(i).getType();
                    Type parameterType = this.parameters.get(i).getType();
                    return argumentType.equals(parameterType);
                });
    }
}
