package me.toylep.spring.cloudnative.merchservice.web;

import me.toylep.spring.cloudnative.merchservice.domain.Merch;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@JsonTest
class MerchJsonTests {

    @Autowired
    private JacksonTester<Merch> json;

    @Test
    void testSerialize() throws  Exception{
        var merch = new Merch("1234512345", "title", 9.0, "minsu");

        var jsonContent = json.write(merch);
        assertThat(jsonContent).extractingJsonPathStringValue("@.isMn")
                .isEqualTo(merch.isMn());
        assertThat(jsonContent).extractingJsonPathStringValue("@.title")
                .isEqualTo(merch.title());
        assertThat(jsonContent).extractingJsonPathNumberValue("@.price")
                .isEqualTo(merch.price());
        assertThat(jsonContent).extractingJsonPathStringValue("@.author")
                .isEqualTo(merch.author());

    }

    @Test
    void testDeserialize() throws Exception {
        var content = """
                {
                    "isMn": "1234567890",
                    "title": "Title",
                    "price": 9.1,
                    "author": "minsu"
                }
                """;

        assertThat(json.parse(content))
                .usingRecursiveComparison()
                .isEqualTo(new Merch("1234567890", "Title", 9.1, "minsu"));
    }


}