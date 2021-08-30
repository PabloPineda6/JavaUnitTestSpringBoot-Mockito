package com.unittestingproject.unittesting.spike;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class JsonPathTest {

    @Test
    public void learning() {
        String responseFromService = "[\n" +
                "{\"id\":10000, \"name\":\"Pencil\", \"quantity\":5},\n" +
                "{\"id\":10001, \"name\":\"Pen\", \"quantity\":15},\n" +
                "{\"id\":10002, \"name\":\"Eraser\", \"quantity\":10}\n" +
                "]";

        DocumentContext context = JsonPath.parse(responseFromService);
        int length = context.read("$.length()");
        assertThat(length).isEqualTo(3);

        assertThat(context.read("$..id").toString()).contains("10000", "10002");

        System.out.println(context.read("$..id").toString());
        System.out.println(context.read("$.[1]").toString());
        System.out.println(context.read("$.[0:1]").toString());
        System.out.println(context.read("$.[?(@.name=='Eraser')]").toString());
        System.out.println(context.read("$.[?(@.quantity==5)]").toString());

    }
}
