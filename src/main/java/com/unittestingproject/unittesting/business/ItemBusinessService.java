package com.unittestingproject.unittesting.business;

import com.unittestingproject.unittesting.model.Item;
import org.springframework.stereotype.Component;

@Component
public class ItemBusinessService {
    public Item retrieveHardcodedItem() {
        return new Item(1, "ball", 10, 100);
    }
}