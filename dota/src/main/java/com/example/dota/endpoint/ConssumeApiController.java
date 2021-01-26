package com.example.dota.endpoint;

import com.example.dota.service.ApiCepConsumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class ConssumeApiController {

    @Autowired
    ApiCepConsumeService service;

    @GetMapping({"cep","/cep"})
    public Object consumeApiCep(@RequestBody String cep) throws IOException {
        return service.apiViaCep(cep);
    }

}
