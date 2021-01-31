package com.example.dota.endpoint;

import com.example.dota.exception.BadRequestException;
import com.example.dota.filter.CurrierFilter;
import com.example.dota.resource.CurrierResource;
import com.example.dota.service.CurrierserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriBuilder;

import java.net.URI;
import java.util.List;

/**
 * Endpoint de acesso das requisicoes referents aos servicos relacionados a currier.
 *
 * @author zeck
 * @version 1
 * @since 31/01/2021
 */

@RestController
@RequestMapping("/currier")
public class CurrierController {

    private static final Logger LOGGER = LogManager.getLogger(CurrierController.class);

    UriBuilder uriBuilder;

    @Autowired
    private CurrierserService currierserService;


    @GetMapping({"/jpa","jpa"})
    public ResponseEntity<?> findJPA(){
        LOGGER.info("Class ConssumeApiController : Method findJPA() -> START");
        return  ResponseEntity.status(HttpStatus.OK).body(currierserService.findJPA());
    }

    @GetMapping({"/native","native"})
    public ResponseEntity<?> findNativeQuery(@RequestBody String name){
        LOGGER.info("Class ConssumeApiController : Method findNativeQuery() -> START");
        return  ResponseEntity.status(HttpStatus.OK).body(currierserService.findNativeQuery(name));
    }

    @GetMapping({"/hql","hql"})
    public ResponseEntity<?> findHql(@RequestBody String name){
        LOGGER.info("Class ConssumeApiController : Method findHql() -> START");
        return  ResponseEntity.status(HttpStatus.OK).body(currierserService.findHql(name));
    }

    @GetMapping({"page","/page"})
    public ResponseEntity<Page<?>> findAll(Pageable page){
        LOGGER.info("Class ConssumeApiController : Method findAll(pageable) -> START");
        Page<?> find = currierserService.findAll(page.previousOrFirst());
        return ResponseEntity.ok(find);
    }

    @GetMapping({"","/"})
    public ResponseEntity<?> findAll(){
        LOGGER.info("Class ConssumeApiController : Method findAll() -> START");
        List<?> find = currierserService.findAll();
        return ResponseEntity.ok(find);
    }

    @GetMapping({"{id}","/{id}"})
    public ResponseEntity<?> findById(@PathVariable(name = "id") Long  id){
        LOGGER.info("Class ConssumeApiController : Method findById() -> START");
        return  ResponseEntity.status(HttpStatus.OK).body(currierserService.findById(id));
    }

    @GetMapping({"filter","/filter"})
    public ResponseEntity<Object> findByFilter(@RequestBody CurrierFilter filter){
        LOGGER.info("Class ConssumeApiController : Method findByFilter() -> START");

        verifyFilter(filter);

        List<?> filtered = currierserService.findByFilter(filter);

        return ResponseEntity.status(HttpStatus.OK).body(filtered);
    }

    @GetMapping({"filterPage","/filterPage"})
    public ResponseEntity<Object> findByFilter(@RequestBody CurrierFilter filter, Pageable page){
        LOGGER.info("Class ConssumeApiController : Method findByFilter(params) -> START");

        verifyFilter(filter);

        Page<?> filtered = currierserService.findByFilter(filter, page);

        return ResponseEntity.status(HttpStatus.OK).body(filtered);
    }

    @PostMapping({"",""})
    public ResponseEntity<?> save(@Validated @RequestBody CurrierResource resource){
        LOGGER.info("Class ConssumeApiController : Method save() -> START");

        return  ResponseEntity.created(URI.create("")).body(currierserService.post(resource));
    }

    @PutMapping({"{id}","/{id}"})
    public  ResponseEntity<?> update(@Validated @PathVariable(name = "id") Long id, @RequestBody CurrierResource resource){
        LOGGER.info("Class ConssumeApiController : Method update() -> START");
        return ResponseEntity.status(HttpStatus.OK).body(currierserService.update(id, resource));
    }

    @DeleteMapping({"{id}","/{id}"})
    public ResponseEntity delete(@PathVariable(name = "id") Long id){
        LOGGER.info("Class ConssumeApiController : Method delete() -> START");
        currierserService.delete(id);
        return   ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping({"","/"})
    public ResponseEntity deleteObject(@RequestBody CurrierResource resource){
        LOGGER.info("Class ConssumeApiController : Method deleteObject() -> START");
        currierserService.deleteByObject(resource);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    private void verifyFilter(@RequestBody CurrierFilter filter) {
        LOGGER.info("Class ConssumeApiController : Method verifyFilter() -> START");
        if(filter == null || filter.equals(null)){
            throw  new BadRequestException();
        }
    }

}
