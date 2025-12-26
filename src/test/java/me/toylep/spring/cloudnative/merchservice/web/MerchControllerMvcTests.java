package me.toylep.spring.cloudnative.merchservice.web;

import me.toylep.spring.cloudnative.merchservice.domain.MerchNotFoundException;
import me.toylep.spring.cloudnative.merchservice.domain.MerchService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MerchContorller.class)
class MerchControllerMvcTests {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private MerchService merchService;

    @Test
    void whenGetMerchNotExistingThenShouldReturn404() throws Exception {
        String ismn = "1231231231";
        given(merchService.viewMerchDetails(ismn)).
        willThrow(MerchNotFoundException.class);
        mockMvc
                .perform(get("/merchs/"+ismn))
                .andExpect(status().isNotFound());
    }

}