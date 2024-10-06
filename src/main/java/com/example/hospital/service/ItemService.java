package com.example.hospital.service;

import com.example.hospital.entities.Item;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ItemService {
    private final Map<Integer, Item> itemMap = new HashMap<>();

    private static final int ITEMS_PER_PAGE = 10;

    public ItemService() {
        for (int i = 0; i < 100; i++) {
            itemMap.put(i, new Item(i, "Item " + i));
        }
    }

    public List<Item> getItemsByPage(int page) {
        int offSet = (page - 1) * ITEMS_PER_PAGE;
        List<Item> items = new ArrayList<>(itemMap.values());

        return items.subList(offSet, Math.min(items.size(), offSet + ITEMS_PER_PAGE));
    }

    public int getItemCount() {
        return itemMap.size();
    }
}
