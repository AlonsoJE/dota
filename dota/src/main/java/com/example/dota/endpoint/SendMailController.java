package com.example.dota.endpoint;

import com.example.dota.service.SendMailService;
import com.example.dota.valueobjects.StatsMail;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Endpoint de acesso das requisicoes referents aos servicos relacionados a Mail.
 *
 * @author zeck
 * @version 1
 * @since 31/01/2021
 */

@RestController
@RequestMapping("/mail")
public class SendMailController {

    private static final Logger LOGGER = LogManager.getLogger(SendMailController.class);

    @Autowired
    SendMailService sendMailService;

    @GetMapping({"send","/send"})
    public ResponseEntity<?> sendSimpleMail(@RequestBody StatsMail statsMail){
        LOGGER.info("Class SendMailController : Method sendSimpleMail() -> START");

        sendMailService.sendSimpleMail(statsMail);

        return ResponseEntity.ok().build();
    }

    @GetMapping({"sendAppend","/sendAppend"})
    public ResponseEntity<?> sendAppendMail(@RequestBody StatsMail statsMail){
        LOGGER.info("Class SendMailController : Method sendSimpleMail() -> START");

        sendMailService.sendAppendMail(statsMail);

        return ResponseEntity.ok().build();
    }


}
