package com.moskovkin.vlm.domain.type;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class LocalVariable implements Variable {
    private final String name;
    private final Type type;
}
