package com.moskovkin.vlm.domain;

import com.moskovkin.vlm.bytecodegeneration.statement.StatementGenerator;

@FunctionalInterface
public interface Statement {

    void accept(StatementGenerator generator);
}

