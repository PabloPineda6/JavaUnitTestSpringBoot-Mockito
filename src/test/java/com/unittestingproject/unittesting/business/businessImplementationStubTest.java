package com.unittestingproject.unittesting.business;

import com.unittestingproject.unittesting.data.DataService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DataServiceStub implements DataService {

    @Override
    public int[] retrieveAllData() {
        return new int[] { 1, 2, 3 };
    }
}

class DataServiceEmptyStub implements DataService {

    @Override
    public int[] retrieveAllData() {
        return new int[] { };
    }
}

class DataServiceOneValueStub implements DataService {

    @Override
    public int[] retrieveAllData() {
        return new int[] { 5 };
    }
}

// This Unit test example only uses JUnit with Stubs
public class businessImplementationStubTest {

    @Test
    public void calculateSum_stub_basic() {
        businessImplementation business = new businessImplementation();
        business.setDataService(new DataServiceStub());
        assertEquals (6, business.calculateSumUsingDataService());
    }

    @Test
    public void calculateSum_stub_empty() {
        businessImplementation business = new businessImplementation();
        business.setDataService(new DataServiceEmptyStub());
        assertEquals (0, business.calculateSumUsingDataService());
    }

    @Test
    public void calculateSum_stub_oneValue() {
        businessImplementation business = new businessImplementation();
        business.setDataService(new DataServiceOneValueStub());
        assertEquals (5, business.calculateSumUsingDataService());
    }
}
