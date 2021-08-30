package com.unittestingproject.unittesting.business;

import com.unittestingproject.unittesting.data.DataService;

import java.util.Arrays;
import java.util.OptionalInt;

public class businessImplementation {

    private DataService dataService;

    public void setDataService(DataService dataService) {
        this.dataService = dataService;
    }

    // This first Unit test example only uses JUnit
    public int calculateSum (int[] data) {
        return Arrays.stream(data).reduce(Integer::sum).orElse(0);
        /*int sum =0;
        for (int value:data) {
            sum += value;
        }
        return sum;*/
    }

    public int calculateSumUsingDataService () {
        return Arrays.stream(dataService.retrieveAllData()).reduce(Integer::sum).orElse(0);
        /*int sum =0;
        int[] data = dataService.retrieveAllData();
        for (int value:data) {
            sum += value;
        }
        return sum;*/
    }
}
