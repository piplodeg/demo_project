package com.example.demo.controller;

import com.example.demo.entities.Items;
import com.example.demo.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    // create item
    @PostMapping("/")
    public ResponseEntity creat(@RequestBody Items items){
        Items data = itemService.create(items);
        return ResponseEntity.status(HttpStatus.CREATED).body(data);
    }

   //get list of items
    @GetMapping("/")
    public ResponseEntity list(){
        List<Items>list = itemService.List();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    //view single item
    @GetMapping("/{id}")
    public  ResponseEntity show(@PathVariable String id){
       Items showData  = itemService.show(id);
       return ResponseEntity.status(HttpStatus.OK).body(showData);
    }

//    update item
    @PutMapping("/{id}")
    public  ResponseEntity update(@RequestBody Items items,@PathVariable String id){
        Items updateData = itemService.update(items,id);
        return ResponseEntity.status(HttpStatus.OK).body(updateData);
    }

//    delete item
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable String id){
        itemService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Item Deleted Sucessfull!!");
    }


}
