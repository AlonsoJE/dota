package com.example.dota.service;

import com.example.dota.config.MailConfig;
import com.example.dota.valueobjects.StatsMail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SendMailService {

    @Autowired
    MailConfig mailConfig;

    public void sendSimpleMail(StatsMail statsMail){
        mailConfig.sendMail(statsMail.getDestiny(), statsMail.getSubject(), statsMail.getMessageBody());
    }

    public void sendAppendMail(){

    }
}
