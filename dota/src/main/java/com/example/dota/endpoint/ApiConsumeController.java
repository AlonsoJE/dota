package com.example.dota.endpoint;

import com.example.dota.service.ApiCepConsumeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * Classe criada para ter acesso via endpoint ao servico de teste de consumo de api/webservice externo.
 *
 * @author zeck
 * @version 1
 * @since 31/01/2021
 */

@RestController
@RequestMapping("/api")
public class ApiConsumeController {

    private static final Logger LOGGER = LogManager.getLogger(ApiConsumeController.class);

    @Autowired
    ApiCepConsumeService service;

    @GetMapping({"cep","/cep"})
    public Object consumeApiCep(@RequestBody String cep) throws IOException {
        LOGGER.info("Class ConssumeApiController : Method consumeApiCep() -> START");
        return service.apiViaCep(cep);
    }

}
