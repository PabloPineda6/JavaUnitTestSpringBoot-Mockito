package com.unittestingproject.unittesting.controller;

import com.unittestingproject.unittesting.business.ItemBusinessService;
import com.unittestingproject.unittesting.model.Item;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.hamcrest.core.StringContains.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@ExtendWith(SpringExtension.class)
@WebMvcTest(ItemController.class)
// In the course, only GET request methods are used, In this class I test a POST, which behavior applies also to PUT, DELETE, etc.
public class OtherRequestTypesTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemBusinessService businessService;

    @Test
    public void itemFromBusinessService_basic() throws Exception {
        when(businessService.retrieveHardcodedItem()).thenReturn(new Item(2, "Cube", 10, 10));
        RequestBuilder request = MockMvcRequestBuilders
                .post("/items")
                .accept(MediaType.APPLICATION_JSON)
                .content("{\"id\":2,\"name\":\"Cube\",\"price\":10,\"quantity\":10}")
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(header().string("location", containsString("/item/")))
                .andReturn();
    }
}
