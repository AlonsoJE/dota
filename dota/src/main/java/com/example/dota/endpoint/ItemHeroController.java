package com.example.dota.endpoint;

import com.example.dota.exception.BadRequestException;
import com.example.dota.filter.ItemHeroFilter;
import com.example.dota.resource.ItemHeroResource;
import com.example.dota.service.ItemHeroService;
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
 * Endpoint de acesso das requisicoes referents aos servicos relacionados a ItemHero.
 *
 * @author zeck
 * @version 1
 * @since 31/01/2021
 */

@RestController
@RequestMapping("/itemHero")
public class ItemHeroController {

    private static final Logger LOGGER = LogManager.getLogger(ItemHeroController.class);

    UriBuilder uriBuilder;

    @Autowired
    private ItemHeroService service;

    @GetMapping({"","/"})
    public ResponseEntity<List<?>> findAll(){
        LOGGER.info("Class ConssumeApiController : Method findAll() -> START");
        List<?> find = service.findAll();

        return ResponseEntity.ok(find);
    }

    @GetMapping({"{id}","/{id}"})
    public ResponseEntity<?> findById(@PathVariable(name = "id") Long  id){
        LOGGER.info("Class ConssumeApiController : Method findById() -> START");
        return  ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
    }

    @GetMapping({"filter","/filter"})
    public ResponseEntity<?> findByFilter(@RequestBody ItemHeroFilter filter){
        LOGGER.info("Class ConssumeApiController : Method findByFilter() -> START");

        verifyFilter(filter);

        List<?> filtered = service.findByFilter(filter);

        return ResponseEntity.status(HttpStatus.OK).body(filtered);
    }

    @PostMapping({"",""})
    public ResponseEntity<?> save(@Validated @RequestBody ItemHeroResource resource){
        LOGGER.info("Class ConssumeApiController : Method save() -> START");

        return  ResponseEntity.created(URI.create("")).body(service.post(resource));
    }

    @PutMapping({"{id}","/{id}"})
    public  ResponseEntity<?> update(@Validated @PathVariable(name = "id") Long id, @RequestBody ItemHeroResource resource){
        LOGGER.info("Class ConssumeApiController : Method update() -> START");
        return ResponseEntity.status(HttpStatus.OK).body(service.update(id, resource));
    }

    @DeleteMapping({"{id}","/{id}"})
    public ResponseEntity delete(@PathVariable(name = "id") Long id){
        LOGGER.info("Class ConssumeApiController : Method delete() -> START");
        service.delete(id);
        return   ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping({"","/"})
    public ResponseEntity deleteObject(@RequestBody ItemHeroResource resource){
        LOGGER.info("Class ConssumeApiController : Method deleteObject() -> START");
        service.deleteByObject(resource);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    private void verifyFilter(@RequestBody ItemHeroFilter filter) {
        LOGGER.info("Class ConssumeApiController : Method verifyFilter() -> START");
        if(filter == null || filter.equals(null)){
            throw  new BadRequestException();
        }
    }


}
