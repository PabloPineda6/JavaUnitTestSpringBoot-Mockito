package com.unittestingproject.unittesting.business;

import com.unittestingproject.unittesting.data.ItemRepository;
import com.unittestingproject.unittesting.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ItemBusinessService {

    @Autowired
    private ItemRepository repository;

    public Item retrieveHardcodedItem() {
        return new Item(1, "ball", 10, 100);
    }

    public List<Item> retrieveAllItems() {
        List<Item> items = repository.findAll();
        for(Item item:items) { // Just to add some business logic
            item.setValue(item.getPrice()*item.getQuantity());
        }
        return items;
    }

    public int add (int a, int b) {
        return a+b;
    }
}
