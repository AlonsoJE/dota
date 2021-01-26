package com.example.dota.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service
public class MailConfig {

    @Value("${var.util.my-mail}")
    private String myMail;
    @Value("${var.util.my-pass}")
    private String myPass;

    public void sendMail(String destiny, String subject, String messageBody) {
        Properties props = new Properties();
        /** Parâmetros de conexão com servidor Hotmail */
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.host", "smtp.live.com");
        props.put("mail.smtp.socketFactory.port", "587");
        props.put("mail.smtp.socketFactory.fallback", "false");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "587");

        System.out.println(myMail.toString() + myPass.toString());

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myMail, myPass);
            }
        });

        /** Ativa Debug para sessão */
        session.setDebug(true);

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myMail)); // Remetente

            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destiny.trim())); // Destinatário(s)
            message.setSubject(subject);// Assunto
            message.setText(messageBody.concat("\n\n Att DOTAPIRULITO \nContato - alnsoftware@hotmail.com"));
            /** Método para enviar a mensagem criada */
            Transport.send(message);

            System.out.println("Feito!!!");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }


}
