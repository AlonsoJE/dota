package com.example.dota.endpoint;

import com.example.dota.exception.BadRequestException;
import com.example.dota.filter.ItemHeroFilter;
import com.example.dota.resource.ItemHeroResource;
import com.example.dota.service.ItemHeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/itemHero")
public class ItemHeroController {

    UriBuilder uriBuilder;

    @Autowired
    private ItemHeroService service;

    @GetMapping({"","/"})
    public ResponseEntity<List<?>> findAll(){

        List<?> find = service.findAll();

        return ResponseEntity.ok(find);
    }

    @GetMapping({"{id}","/{id}"})
    public ResponseEntity<?> findById(@PathVariable(name = "id") Long  id){
        return  ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
    }

    @GetMapping({"filter","/filter"})
    public ResponseEntity<?> findByFilter(@RequestBody ItemHeroFilter filter){

        verifyFilter(filter);

        List<?> filtered = service.findByFilter(filter);

        return ResponseEntity.status(HttpStatus.OK).body(filtered);
    }

    @PostMapping({"",""})
    public ResponseEntity<?> save(@Validated @RequestBody ItemHeroResource resource){

        return  ResponseEntity.created(URI.create("")).body(service.post(resource));
    }

    @PutMapping({"{id}","/{id}"})
    public  ResponseEntity<?> update(@Validated @PathVariable(name = "id") Long id, @RequestBody ItemHeroResource resource){
        return ResponseEntity.status(HttpStatus.OK).body(service.update(id, resource));
    }

    @DeleteMapping({"{id}","/{id}"})
    public ResponseEntity delete(@PathVariable(name = "id") Long id){
        service.delete(id);
        return   ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping({"","/"})
    public ResponseEntity deleteObject(@RequestBody ItemHeroResource resource){
        service.deleteByObject(resource);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    private void verifyFilter(@RequestBody ItemHeroFilter filter) {
        if(filter == null || filter.equals(null)){
            throw  new BadRequestException();
        }
    }


}
