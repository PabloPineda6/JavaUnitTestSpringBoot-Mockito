package com.unittestingproject.unittesting.spike;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {

    String serviceResponse = "{\"id\":1,\"name\":\"ball\",\"price\":10,\"quantity\":100}";
    @Test
    public void jsonAssertStrict() throws JSONException {
        String expectedResponse = "{\"id\":   1,\"name\":\"ball\",\"price\":10,\"quantity\":100}";
        JSONAssert.assertEquals(expectedResponse, serviceResponse, true);
    }

    @Test
    public void jsonAssertNonStrict() throws JSONException {
        String expectedResponse = "{\"id\":   1,\"quantity\":100}";
        JSONAssert.assertEquals(expectedResponse, serviceResponse, false);
    }

    @Test
    public void jsonAssert_WithoutEscapeCharacters() throws JSONException {
        String expectedResponse = "{id:   1,name:ball,quantity:100}";
        JSONAssert.assertEquals(expectedResponse, serviceResponse, false);
    }
}
