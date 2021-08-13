package com.unittestingproject.unittesting.business;

import com.unittestingproject.unittesting.data.DataService;

public class businessImplementation {

    private DataService dataService;

    public void setDataService(DataService dataService) {
        this.dataService = dataService;
    }

    // This first Unit test example only uses JUnit
    public int calculateSum (int[] data) {
        int sum =0;
        for (int value:data) {
            sum += value;
        }
        return sum;
    }

    public int calculateSumUsingDataService () {
        int sum =0;
        int[] data = dataService.retrieveAllData();
        for (int value:data) {
            sum += value;
        }
        return sum;
    }
}
