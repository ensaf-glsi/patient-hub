package com.ids.patienthub.greeting.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Greeting {
    private Long id;
    private String content;
}
