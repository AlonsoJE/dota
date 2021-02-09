package com.example.dota.endpoint;

import com.example.dota.exception.BadRequestException;
import com.example.dota.filter.HeroFilter;
import com.example.dota.resource.HeroResource;
import com.example.dota.service.HeroService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriBuilder;

import java.net.URI;
import java.util.List;

/**
 * Endpoint de acesso das requisicoes referents aos servicos relacionados a Hero.
 *
 * @author zeck
 * @version 1
 * @since 31/01/2021
 */

@RestController
@RequestMapping("/hero")
public class HeroController {

    private static final Logger LOGGER = LogManager.getLogger(HeroController.class);

    UriBuilder uriBuilder;

    @Autowired
    private HeroService heroService;

    @GetMapping({"{id}/stats","/{id}/stats"})
    public ResponseEntity<?> verifyStatsHero(@PathVariable(name = "id") Long id){
        LOGGER.info("Class ConssumeApiController : Method verifyStatsHero() -> START");
        return ResponseEntity.status(HttpStatus.OK).body(heroService.verifyAllStats(id, heroService.findById(id)));
    }


    @GetMapping({"","/"})
    public ResponseEntity<List<?>> findAll(){
        LOGGER.info("Class ConssumeApiController : Method findAll() -> START");

        List<?> find = heroService.findAll();

        return ResponseEntity.ok(find);
    }

    @GetMapping({"{id}","/{id}"})
    public ResponseEntity<?> findById(@PathVariable(name = "id") Long  id){
        LOGGER.info("Class ConssumeApiController : Method findById() -> START");
        return  ResponseEntity.status(HttpStatus.OK).body(heroService.findById(id));
    }

    @GetMapping({"filter","/filter"})
    public ResponseEntity<?> findByFilter(@RequestBody HeroFilter heroFilter){
        LOGGER.info("Class ConssumeApiController : Method findByFilter() -> START");

        verifyFilter(heroFilter);
        return ResponseEntity.status(HttpStatus.OK).body(heroService.findByFilter(heroFilter));
    }

    @PostMapping({"",""})
    public ResponseEntity<?> save(@Validated @RequestBody HeroResource resource){
        LOGGER.info("Class ConssumeApiController : Method save() -> START");

        return  ResponseEntity.created(URI.create("")).body(heroService.post(resource));
    }

    @PutMapping({"{id}","/{id}"})
    public  ResponseEntity<?> update(@Validated @PathVariable(name = "id") Long id, @RequestBody HeroResource resource){
        LOGGER.info("Class ConssumeApiController : Method update() -> START");
        return ResponseEntity.status(HttpStatus.OK).body(heroService.update(id, resource));
    }

    @DeleteMapping({"{id}","/{id}"})
    public ResponseEntity delete(@PathVariable(name = "id") Long id){
        LOGGER.info("Class ConssumeApiController : Method delete() -> START");
        heroService.delete(id);
        return   ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping({"","/"})
    public ResponseEntity deleteObject(@RequestBody HeroResource resource){
        LOGGER.info("Class ConssumeApiController : Method deleteObject() -> START");
        heroService.deleteByObject(resource);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    private void verifyFilter(@RequestBody HeroFilter heroFilter) {
        LOGGER.info("Class ConssumeApiController : Method verifyFilter() -> START");
        if(heroFilter == null || heroFilter.equals(null)){
            throw  new BadRequestException();
        }
    }
}
