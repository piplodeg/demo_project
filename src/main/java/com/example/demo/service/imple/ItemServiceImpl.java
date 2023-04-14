package com.example.demo.service.imple;

import com.example.demo.entities.Items;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repositories.ItemRepositories;
import com.example.demo.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepositories itemRepositories;
    @Override
    public Items create(Items items) {
        Items save = itemRepositories.save(items);
        return save;
    }

    @Override
    public Items update(Items items, String id) {
        Items updateData = itemRepositories.findItemById(id);
        if(updateData == null)
        throw new ResourceNotFoundException("Items", "item id", id);
        updateData.setName(items.getName());
        updateData.setAmount(items.getAmount());
        updateData.setDescription(items.getDescription());
        Items data = itemRepositories.save(updateData);
        return data;
    }

    @Override
    public List<Items> List() {
        List<Items>list = itemRepositories.findAll();
        return list;
    }

    @Override
    public Items show(String id) {
        Items showData = itemRepositories.findItemById(id);
        if(showData ==null)
            throw new ResourceNotFoundException("Items", "item id", id);
        return showData;
    }

    @Override
    public void delete(String id) {
        itemRepositories.deleteByid(id);
    }
}
