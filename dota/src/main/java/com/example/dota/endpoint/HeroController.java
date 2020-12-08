package com.example.dota.endpoint;

import com.example.dota.entity.HeroEntity;
import com.example.dota.filter.HeroFilter;
import com.example.dota.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriBuilder;

import java.util.List;

@RestController
@RequestMapping("")
public class HeroController {

    UriBuilder uriBuilder;

    @Autowired
    private HeroService heroService;

    @GetMapping({"","/"})
    public ResponseEntity<List<HeroEntity>> findAll(){

        List<HeroEntity> find = heroService.findAll();

        return ResponseEntity.ok(find);
    }

    @GetMapping({"{id}","/{id}"})
    public ResponseEntity<Object> findById(@PathVariable(name = "id") Long  id){
        return  ResponseEntity.status(HttpStatus.OK).body(heroService.findById(id));
    }

    @GetMapping({"filter","/filter"})
    public ResponseEntity<Object> findByFilter(@RequestBody HeroFilter heroFilter){

        List<Object> filtered = heroService.findByFilter(heroFilter);

        return ResponseEntity.status(HttpStatus.OK).body(filtered);
    }

    @PostMapping({"",""})
    public ResponseEntity<Object> save(@Validated @RequestBody HeroEntity heroEntity){
        return  ResponseEntity.ok(heroService.post(heroEntity));
    }


    @PutMapping({"{id}","/{id}"})
    public  ResponseEntity<Object> update(@Validated @PathVariable(name = "id") Long id, @RequestBody HeroEntity heroEntity){
        return ResponseEntity.status(HttpStatus.OK).body(heroService.update(id, heroEntity));
    }

    @DeleteMapping({"{id}","/{id}"})
    public ResponseEntity delete(@PathVariable(name = "id") Long id){
        heroService.delete(id);
        return   ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping({"","/"})
    public ResponseEntity deleteObject(@RequestBody HeroEntity heroEntity){
        heroService.deleteByObject(heroEntity);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
