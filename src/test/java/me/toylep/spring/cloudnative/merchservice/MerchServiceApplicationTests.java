package me.toylep.spring.cloudnative.merchservice;

import me.toylep.spring.cloudnative.merchservice.domain.Merch;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
class MerchServiceApplicationTests {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void whenPostRequestThenMerchCreated(){
        var expctedMerch = new Merch("1231231231", "title" ,1.2, "minsu");

        webTestClient
                .post()
                .uri("/merchs")
                .bodyValue(expctedMerch)
                .exchange()
                .expectBody(Merch.class).value(actualMerch ->{
                    assertThat(actualMerch).isNotNull();
                    assertThat(actualMerch.isMn()).isEqualTo(expctedMerch.isMn());
                });

    }

}