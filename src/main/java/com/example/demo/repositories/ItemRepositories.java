package com.example.demo.repositories;

import com.example.demo.entities.Items;
import org.springframework.data.mongodb.repository.DeleteQuery;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface ItemRepositories extends MongoRepository<Items,Integer> {
    @Query("{id:'?0'}")
    Items findItemById(String id);
    @Query(value="{'_id' : ?0}", delete = true)
    void deleteByid(String id);
}
