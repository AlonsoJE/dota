package com.example.dota.endpoint;

import com.example.dota.service.SendMailService;
import com.example.dota.valueobjects.StatsMail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mail")
public class SendMailController {

    @Autowired
    SendMailService sendMailService;

    @GetMapping({"send","/send"})
    public ResponseEntity<?> sendSimpleMail(@RequestBody StatsMail statsMail){

        sendMailService.sendSimpleMail(statsMail);

        return ResponseEntity.ok().build();
    }


}
