package com.example.dota.endpoint;

import com.example.dota.exception.BadRequestException;
import com.example.dota.filter.HeroFilter;
import com.example.dota.resource.HeroResource;
import com.example.dota.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/hero")
public class HeroController {

    UriBuilder uriBuilder;

    @Autowired
    private HeroService heroService;

    // ↓ BUSINESS RULES ↓

    @GetMapping({"{id}/stats","/{id}/stats"})
    public ResponseEntity<?> verifyStatsHero(@PathVariable(name = "id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(heroService.verifyAllStats(id, heroService.findById(id)));
    }

    //↓ BASIC METHODS ↓

    @GetMapping({"","/"})
    public ResponseEntity<List<?>> findAll(){

        List<?> find = heroService.findAll();

        return ResponseEntity.ok(find);
    }

    @GetMapping({"{id}","/{id}"})
    public ResponseEntity<?> findById(@PathVariable(name = "id") Long  id){
        return  ResponseEntity.status(HttpStatus.OK).body(heroService.findById(id));
    }

    @GetMapping({"filter","/filter"})
    public ResponseEntity<?> findByFilter(@RequestBody HeroFilter heroFilter){

        verifyFilter(heroFilter);

        List<?> filtered = heroService.findByFilter(heroFilter);

        return ResponseEntity.status(HttpStatus.OK).body(filtered);
    }

    @PostMapping({"",""})
    public ResponseEntity<?> save(@Validated @RequestBody HeroResource resource){

        return  ResponseEntity.created(URI.create("")).body(heroService.post(resource));
    }

    @PutMapping({"{id}","/{id}"})
    public  ResponseEntity<?> update(@Validated @PathVariable(name = "id") Long id, @RequestBody HeroResource resource){
        return ResponseEntity.status(HttpStatus.OK).body(heroService.update(id, resource));
    }

    @DeleteMapping({"{id}","/{id}"})
    public ResponseEntity delete(@PathVariable(name = "id") Long id){
        heroService.delete(id);
        return   ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping({"","/"})
    public ResponseEntity deleteObject(@RequestBody HeroResource resource){
        heroService.deleteByObject(resource);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    private void verifyFilter(@RequestBody HeroFilter heroFilter) {
        if(heroFilter == null || heroFilter.equals(null)){
            throw  new BadRequestException();
        }
    }
}
