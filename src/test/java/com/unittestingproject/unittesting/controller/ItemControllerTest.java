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

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ItemController.class)
public class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemBusinessService businessService;

    @Test
    public void dummyItem_basic() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders
                .get("/dummy-item")
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("{\"id\":1,\"name\":\"ball\",\"price\":10,\"quantity\":100}"))
                .andExpect(content().json("{\"id\":    1,\"name\":\"ball\",\"price\":10}"))
                .andReturn();

        // Assertion not needed, already done using the .andExpect matcher statements
    }

    @Test
    public void itemFromBusinessService_basic() throws Exception {
        when(businessService.retrieveHardcodedItem()).thenReturn(new Item(2, "Cube", 10, 10));
        RequestBuilder request = MockMvcRequestBuilders
                .get("/item-from-business-service")
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("{\"id\":2,\"name\":\"Cube\",\"price\":10,\"quantity\":10}"))
                .andExpect(content().json("{\"id\":    2,\"name\":\"Cube\",\"price\":10}"))
                .andReturn();

        // Assertion not needed, already done using the .andExpect matcher statements
    }

    @Test
    public void retrieveAllItems_basic() throws Exception {
        when(businessService.retrieveAllItems()).thenReturn(
                Arrays.asList(new Item(2, "Cube", 10, 10),
                              new Item(3, "pyramid", 8, 12),
                              new Item(4, "Tetrahedron", 9, 20))
        );
        RequestBuilder request = MockMvcRequestBuilders
                .get("/all-items-from-database")
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(
                        "[{\"id\":2,\"name\":\"Cube\",\"price\":10,\"quantity\":10,\"value\":0},"
                                     +"{\"id\":3,\"name\":\"pyramid\",\"price\":8,\"quantity\":12,\"value\":0},"
                                     +"{\"id\":4,\"name\":\"Tetrahedron\",\"price\":9,\"quantity\":20,\"value\":0}]"))
                .andExpect(content().json("[{\"id\":    2,\"name\":\"Cube\",\"price\":10},"
                                                    +"{\"id\":3,\"name\":\"pyramid\",\"quantity\":12,\"value\":0},"
                                                    +"{}]"))
                .andReturn();

        // Assertion not needed, already done using the .andExpect matcher statements
    }
}
