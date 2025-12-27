package me.toylep.spring.cloudnative.merchservice.domain;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @Valid 를 검증하는 테스트 코드
 */
class MerchValidationTests {
    private static Validator validator;

    @BeforeAll
    static void setUp(){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    @DisplayName("유효코드 생성")
    void whenAllFieldsCorrectThenValidationSucceeds(){
        var merch = new Merch("1234567890123", "title", 9.00,"1" );
        Set<ConstraintViolation<Merch>> violations = validator.validate(merch);
        assertThat(violations).isEmpty();
    }

    @Test
    @DisplayName("none Valid")
    void whenIsmnDefinedButIncorrectThenValidationFails(){
        var merch = new Merch("a1234567890123", "title", 9.00,"1" );
        Set<ConstraintViolation<Merch>> violations = validator.validate(merch);
        assertThat(violations).hasSize(1);
        assertThat(violations.iterator().next().getMessage())
                .isEqualTo("검증되지 않은 굿즈 일련번호입니다.");
    }


}