package com.moskovkin.vlm.domain;

import com.moskovkin.vlm.domain.type.Type;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Field {

    private final String name;
    private final String classOwner;
    private final Type type;
}
