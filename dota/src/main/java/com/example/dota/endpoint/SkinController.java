package com.example.dota.endpoint;

import com.example.dota.exception.BadRequestException;
import com.example.dota.filter.SkinFilter;
import com.example.dota.resource.SkinResource;
import com.example.dota.service.SkinService;
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
 * Endpoint de acesso das requisicoes referents aos servicos relacionados a Skin.
 *
 * @author zeck
 * @version 1
 * @since 31/01/2021
 */

@RestController
@RequestMapping("/skin")
public class SkinController {

    private static final Logger LOGGER = LogManager.getLogger(SkinController.class);

    UriBuilder uriBuilder;

    @Autowired
    private SkinService skinService;

    @GetMapping({"","/"})
    public ResponseEntity<List<?>> findAll(){
        LOGGER.info("Class ConssumeApiController : Method findAll() -> START");
        List<?> find = skinService.findAll();

        return ResponseEntity.ok(find);
    }

    @GetMapping({"{id}","/{id}"})
    public ResponseEntity<?> findById(@PathVariable(name = "id") Long  id){
        LOGGER.info("Class ConssumeApiController : Method findById() -> START");
        return  ResponseEntity.status(HttpStatus.OK).body(skinService.findById(id));
    }

    @GetMapping({"filter","/filter"})
    public ResponseEntity<?> findByFilter(@RequestBody SkinFilter filter){
        LOGGER.info("Class ConssumeApiController : Method findByFilter() -> START");

        verifyFilter(filter);

        List<?> filtered = skinService.findByFilter(filter);

        return ResponseEntity.status(HttpStatus.OK).body(filtered);
    }

    @PostMapping({"",""})
    public ResponseEntity<?> save(@Validated @RequestBody SkinResource resource){
        LOGGER.info("Class ConssumeApiController : Method save() -> START");

        return  ResponseEntity.created(URI.create("")).body(skinService.post(resource));
    }

    @PutMapping({"{id}","/{id}"})
    public  ResponseEntity<?> update(@Validated @PathVariable(name = "id") Long id, @RequestBody SkinResource resource){
        LOGGER.info("Class ConssumeApiController : Method update() -> START");
        return ResponseEntity.status(HttpStatus.OK).body(skinService.update(id, resource));
    }

    @DeleteMapping({"{id}","/{id}"})
    public ResponseEntity delete(@PathVariable(name = "id") Long id){
        LOGGER.info("Class ConssumeApiController : Method delete() -> START");
        skinService.delete(id);
        return   ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping({"","/"})
    public ResponseEntity deleteObject(@RequestBody SkinResource resource){
        LOGGER.info("Class ConssumeApiController : Method deleteObject() -> START");
        skinService.deleteByObject(resource);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


    private void verifyFilter(@RequestBody SkinFilter skinFilter) {
        LOGGER.info("Class ConssumeApiController : Method verifyFilter() -> START");
        if(skinFilter == null || skinFilter.equals(null)){
            throw  new BadRequestException();
        }
    }

}



