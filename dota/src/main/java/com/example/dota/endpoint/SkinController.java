package com.example.dota.endpoint;

import com.example.dota.entity.SkinEntity;
import com.example.dota.service.SkinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/skin")
public class SkinController {

    UriBuilder uriBuilder;

    @Autowired
    private SkinService skinService;

    @GetMapping({"","/"})
    public ResponseEntity<List<?>> findAll(){

        List<?> find = skinService.findAll();

        return ResponseEntity.ok(find);
    }

    @GetMapping({"{id}","/{id}"})
    public ResponseEntity<?> findById(@PathVariable(name = "id") Long  id){
        return  ResponseEntity.status(HttpStatus.OK).body(skinService.findById(id));
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
    public ResponseEntity<?> save(@Validated @RequestBody SkinEntity skinEntity){

        return  ResponseEntity.created(URI.create("")).body(skinService.post(skinEntity));
    }

    @PutMapping({"{id}","/{id}"})
    public  ResponseEntity<?> update(@Validated @PathVariable(name = "id") Long id, @RequestBody SkinEntity skinEntity){
        return ResponseEntity.status(HttpStatus.OK).body(skinService.update(id, skinEntity));
    }

    @DeleteMapping({"{id}","/{id}"})
    public ResponseEntity delete(@PathVariable(name = "id") Long id){
        skinService.delete(id);
        return   ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping({"","/"})
    public ResponseEntity deleteObject(@RequestBody SkinEntity skinEntity){
        skinService.deleteByObject(skinEntity);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

//
//    private void verifyFilter(@RequestBody SkinFilter skinFilter) {
//        if(skinFilter == null || skinFilter.equals(null)){
//            throw  new BadRequestException();
//        }
//    }

//}


}
