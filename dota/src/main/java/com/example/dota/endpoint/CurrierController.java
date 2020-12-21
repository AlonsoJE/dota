package com.example.dota.endpoint;

import com.example.dota.entity.CurrierEntity;
import com.example.dota.exception.BadRequestException;
import com.example.dota.filter.HeroFilter;
import com.example.dota.service.CurrierserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/currier")
public class CurrierController {

    UriBuilder uriBuilder;

    @Autowired
    private CurrierserService currierserService;

    @GetMapping({"","/"})
    public ResponseEntity<List<?>> findAll(){

        List<?> find = currierserService.findAll();

        return ResponseEntity.ok(find);
    }

    @GetMapping({"{id}","/{id}"})
    public ResponseEntity<Object> findById(@PathVariable(name = "id") Long  id){
        return  ResponseEntity.status(HttpStatus.OK).body(currierserService.findById(id));
    }

//    @GetMapping({"filter","/filter"})
//    public ResponseEntity<Object> findByFilter(@RequestBody HeroFilter heroFilter){
//
//        verifyFilter(heroFilter);
//
//        List<Object> filtered = currierserService.findByFilter(heroFilter);
//
//        return ResponseEntity.status(HttpStatus.OK).body(filtered);
//    }

    @PostMapping({"",""})
    public ResponseEntity<Object> save(@Validated @RequestBody CurrierEntity currierEntity){

        return  ResponseEntity.created(URI.create("")).body(currierserService.post(currierEntity));
    }

    @PutMapping({"{id}","/{id}"})
    public  ResponseEntity<?> update(@Validated @PathVariable(name = "id") Long id, @RequestBody CurrierEntity currierEntity){
        return ResponseEntity.status(HttpStatus.OK).body(currierserService.update(id, currierEntity));
    }

    @DeleteMapping({"{id}","/{id}"})
    public ResponseEntity delete(@PathVariable(name = "id") Long id){
        currierserService.delete(id);
        return   ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping({"","/"})
    public ResponseEntity deleteObject(@RequestBody CurrierEntity currierEntity){
        currierserService.deleteByObject(currierEntity);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    private void verifyFilter(@RequestBody HeroFilter heroFilter) {
        if(heroFilter == null || heroFilter.equals(null)){
            throw  new BadRequestException();
        }
    }

}
