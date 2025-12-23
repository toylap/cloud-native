package me.toylep.spring.cloudnative.merchservice.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

public record Merch(

    @NotBlank(message = "굿즈 번호가 없습니다.")
    @Pattern(
        regexp ="^[0-9]{10}|[0-9]{13}$",
        message = "검증되지 않은 굿즈 일련번호입니다."
    )
    String isMn,
    @NotBlank(message = "제목이 없습니다.")
    String title,
    @NotNull(message = "값이 없습니다.")
    @Positive(
        message = "해당 값은 양수여야합니다."
    )
    Double price,
    @NotBlank(message = "작가 이름이 없습니다.")
    String author
) {}
