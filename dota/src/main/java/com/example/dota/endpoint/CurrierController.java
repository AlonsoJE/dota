package com.example.dota.endpoint;

import com.example.dota.exception.BadRequestException;
import com.example.dota.filter.CurrierFilter;
import com.example.dota.resource.CurrierResource;
import com.example.dota.service.CurrierserService;
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

@RestController
@RequestMapping("/currier")
public class CurrierController {

    UriBuilder uriBuilder;

    @Autowired
    private CurrierserService currierserService;


    @GetMapping({"/jpa","jpa"})
    public ResponseEntity<?> findJPA(){
        return  ResponseEntity.status(HttpStatus.OK).body(currierserService.findJPA());
    }

    @GetMapping({"/native","native"})
    public ResponseEntity<?> findNativeQuery(@RequestBody String name){
        return  ResponseEntity.status(HttpStatus.OK).body(currierserService.findNativeQuery(name));
    }

    @GetMapping({"/hql","hql"})
    public ResponseEntity<?> findHql(@RequestBody String name){
        return  ResponseEntity.status(HttpStatus.OK).body(currierserService.findHql(name));
    }

    @GetMapping({"page","/page"})
    public ResponseEntity<Page<?>> findAll(Pageable page){

        Page<?> find = currierserService.findAll(page.previousOrFirst());

        return ResponseEntity.ok(find);
    }

    @GetMapping({"","/"})
    public ResponseEntity<?> findAll(){

        List<?> find = currierserService.findAll();

        return ResponseEntity.ok(find);
    }

    @GetMapping({"{id}","/{id}"})
    public ResponseEntity<?> findById(@PathVariable(name = "id") Long  id){
        return  ResponseEntity.status(HttpStatus.OK).body(currierserService.findById(id));
    }

    @GetMapping({"filter","/filter"})
    public ResponseEntity<Object> findByFilter(@RequestBody CurrierFilter filter){

        verifyFilter(filter);

        List<?> filtered = currierserService.findByFilter(filter);

        return ResponseEntity.status(HttpStatus.OK).body(filtered);
    }

    @GetMapping({"filterPage","/filterPage"})
    public ResponseEntity<Object> findByFilter(@RequestBody CurrierFilter filter, Pageable page){

        verifyFilter(filter);

        Page<?> filtered = currierserService.findByFilter(filter, page);

        return ResponseEntity.status(HttpStatus.OK).body(filtered);
    }

    @PostMapping({"",""})
    public ResponseEntity<?> save(@Validated @RequestBody CurrierResource resource){

        return  ResponseEntity.created(URI.create("")).body(currierserService.post(resource));
    }

    @PutMapping({"{id}","/{id}"})
    public  ResponseEntity<?> update(@Validated @PathVariable(name = "id") Long id, @RequestBody CurrierResource resource){
        return ResponseEntity.status(HttpStatus.OK).body(currierserService.update(id, resource));
    }

    @DeleteMapping({"{id}","/{id}"})
    public ResponseEntity delete(@PathVariable(name = "id") Long id){
        currierserService.delete(id);
        return   ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping({"","/"})
    public ResponseEntity deleteObject(@RequestBody CurrierResource resource){
        currierserService.deleteByObject(resource);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    private void verifyFilter(@RequestBody CurrierFilter filter) {
        if(filter == null || filter.equals(null)){
            throw  new BadRequestException();
        }
    }

}
