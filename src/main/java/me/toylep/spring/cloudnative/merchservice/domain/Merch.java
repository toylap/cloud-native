package me.toylep.spring.cloudnative.merchservice.domain;

public record Merch(
    String isMn,
    String title,
    Double price,
    String author
) {}
