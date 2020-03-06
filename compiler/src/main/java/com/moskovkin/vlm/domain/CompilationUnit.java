package com.moskovkin.vlm.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class CompilationUnit {

    private final ClassDeclaration mainClassDeclaration;

}
