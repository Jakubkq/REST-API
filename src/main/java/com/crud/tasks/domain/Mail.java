package com.crud.tasks.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.Optional;


@AllArgsConstructor
@Getter
@Builder
public class Mail {

    private final String mailTo;
    private final String subject;
    private final String message;
    private final String toCC;

    public Optional<String> getCC() {
        return Optional.ofNullable(toCC);
    }
}
