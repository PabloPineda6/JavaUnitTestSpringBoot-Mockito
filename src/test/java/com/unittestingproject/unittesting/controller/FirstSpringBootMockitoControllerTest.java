package com.unittestingproject.unittesting.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(FirstSpringBootMockitoController.class)
public class FirstSpringBootMockitoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void SpringBootMockitoController_basic() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders
                .get("/get-response")
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("Text to be retrieved"))
                .andReturn();
        // Assertion not needed, already done using the .andExpect matcher statements
        // assertEquals("Text to be retrieved", result.getResponse().getContentAsString());
    }
}
