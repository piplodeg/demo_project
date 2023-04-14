package com.example.demo.service;

import com.example.demo.entities.Items;

import java.util.List;

public interface ItemService {
    Items create(Items items);
    Items update(Items items,String id);
    List<Items>List();
    Items show(String id);
    void delete(String id);
}
