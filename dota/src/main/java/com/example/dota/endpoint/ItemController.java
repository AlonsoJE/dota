package com.example.dota.endpoint;

import com.example.dota.converter.ItemConverter;
import com.example.dota.exception.ResourceNotFoundException;
import com.example.dota.filter.ItemFilter;
import com.example.dota.resource.ItemResource;
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

    private ItemConverter converter = new ItemConverter();

    @GetMapping({"","/"})
    public ResponseEntity<?> findAll(){

        return status(HttpStatus.OK).body(itemService.findAll());

    }

    @GetMapping({"{id}","/{id}"})
    public ResponseEntity<?> findById(@PathVariable(name = "id") Long  id){

        verifyId(id);

        return ResponseEntity.status(200).body(itemService.findById(id));
    }


    @GetMapping({"filter","/filter"})
    public ResponseEntity<?> findByFilter(@RequestBody ItemFilter filter){

        List<?> filtered = itemService.findByFilter(filter);

        return status(HttpStatus.OK).body(filtered);
    }

    @PostMapping({"",""})
    public ResponseEntity<?> save(@Validated @RequestBody ItemResource resource){

        return  ResponseEntity.created(URI.create("")).body(itemService.post(resource));
    }


    @PutMapping({"{id}","/{id}"})
    public  ResponseEntity<?> update(@Validated @PathVariable(name = "id") Long id, @RequestBody ItemResource resource){
        verifyId(id);
        return status(HttpStatus.OK).body(itemService.update(id, resource));
    }

    @DeleteMapping({"{id}","/{id}"})
    public ResponseEntity delete(@PathVariable(name = "id") Long id){
        verifyId(id);
        itemService.delete(id);
        return   status(HttpStatus.OK).build();
    }

    @DeleteMapping({"","/"})
    public ResponseEntity deleteObject(@RequestBody ItemResource resource){
        itemService.deleteByObject(resource);
        return status(HttpStatus.OK).build();
    }


    private void verifyId(@PathVariable(name = "id") Long id) {
        Object result = itemService.findById(id);

        if(result == null){
            throw  new ResourceNotFoundException();
        }
    }

}