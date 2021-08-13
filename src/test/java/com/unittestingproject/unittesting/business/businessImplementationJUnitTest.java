package com.unittestingproject.unittesting.business;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

// This first Unit test example only uses JUnit
public class businessImplementationJUnitTest {

    @Test
    public void calculateSum_basic() {
        businessImplementation business = new businessImplementation();
        int actualResult = business.calculateSum(new int[] { 1, 2, 3 } );
        int expectedResult = 6;
        assertEquals (expectedResult, actualResult);
    }

    @Test
    public void calculateSum_empty() {
        businessImplementation business = new businessImplementation();
        int actualResult = business.calculateSum(new int[] { } );
        int expectedResult = 0;
        assertEquals (expectedResult, actualResult);
    }

    @Test
    public void calculateSum_oneValue() {
        businessImplementation business = new businessImplementation();
        int actualResult = business.calculateSum(new int[] { 5 } );
        int expectedResult = 5;
        assertEquals (expectedResult, actualResult);
    }
}
