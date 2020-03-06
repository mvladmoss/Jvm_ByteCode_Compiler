package com.moskovkin.vlm.domain;

import com.moskovkin.vlm.domain.type.Type;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Parameter {

    private final String name;
    private final Type type;
}
