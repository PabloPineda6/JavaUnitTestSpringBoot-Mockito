package com.unittestingproject.unittesting.business;

import com.unittestingproject.unittesting.data.DataService;
import com.unittestingproject.unittesting.data.ItemRepository;
import com.unittestingproject.unittesting.model.Item;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ItemBusinessServiceTest {

    @InjectMocks
    private ItemBusinessService business;

    @Mock
    ItemRepository repository;

    @Test
    public void calculateSumUsingDataService_basic() {
        when(repository.findAll()).thenReturn(
                Arrays.asList(new Item(2, "Cube", 10, 10),
                              new Item(3, "pyramid", 8, 12),
                              new Item(4, "Tetrahedron", 9, 20)));
        List<Item> items = business.retrieveAllItems();
        assertEquals (100, items.get(0).getValue()); // item.setValue(item.getPrice()*item.getQuantity());
        assertEquals (96, items.get(1).getValue());
    }
}
