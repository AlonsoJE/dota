package com.example.dota.endpoint;

import com.example.dota.entity.ItemEntity;
import com.example.dota.exception.ResourceNotFoundException;
import com.example.dota.filter.ItemFilter;
import com.example.dota.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping({"","/"})
    public ResponseEntity<Object> findAll(){

        return status(HttpStatus.OK).body(itemService.findAll());

    }

    @GetMapping({"{id}","/{id}"})
    public ResponseEntity<?> findById(@PathVariable(name = "id") Long  id){

        verifyId(id);

        return ResponseEntity.status(200).body(itemService.findById(id));
    }


    @GetMapping({"filter","/filter"})
    public ResponseEntity<Object> findByFilter(@RequestBody ItemFilter filter){

        List<?> filtered = itemService.findByFilter(filter);

        return status(HttpStatus.OK).body(filtered);
    }

    @PostMapping({"",""})
    public ResponseEntity<Object> save(@Validated @RequestBody ItemEntity itemEntity){

        return  ResponseEntity.created(URI.create("")).body(itemService.post(itemEntity));
    }


    @PutMapping({"{id}","/{id}"})
    public  ResponseEntity<Object> update(@Validated @PathVariable(name = "id") Long id, @RequestBody ItemEntity itemEntity){
        verifyId(id);
        return status(HttpStatus.OK).body(itemService.update(id, itemEntity));
    }

    @DeleteMapping({"{id}","/{id}"})
    public ResponseEntity delete(@PathVariable(name = "id") Long id){
        verifyId(id);
        itemService.delete(id);
        return   status(HttpStatus.OK).build();
    }

    @DeleteMapping({"","/"})
    public ResponseEntity deleteObject(@RequestBody ItemEntity itemEntity){
        itemService.deleteByObject(itemEntity);
        return status(HttpStatus.OK).build();
    }


    private void verifyId(@PathVariable(name = "id") Long id) {
        Object result = itemService.findById(id);

        if(result == null){
            throw  new ResourceNotFoundException();
        }
    }

}
