package com.example.dota.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

/**
 * Responsavel pela configuracao do servidor de e-mail, porta e suas caracteristicas.
 *
 * @author zeck
 * @version 1
 * @since 31/01/2021
 */
@Service
public class MailConfig {


    @Value("${var.util.my-mail}")
    private String myMail;
    @Value("${var.util.my-pass}")
    private String myPass;

    private static final Logger LOGGER = LogManager.getLogger(MailConfig.class);

    /**
     * Realiza o envio do e-mail de acordo com a configuracao, utilizando os parametros informados.
     * @author zeck
     * @param  destiny -> Destinatario do e-mail.
     * @param  subject -> Assunto do e-mail.
     * @param messageBody -> Corpo do e-mail com o conteúdo a ser enviado.
     * @since 31/01/2021
     * @see com.example.dota.service.SendMailService
     */
    public void simpleMail(String destiny, String subject, String messageBody) {

        LOGGER.info("Class MailConfig : Method sendMail() -> START");

        Properties props = new Properties();

//        Parâmetros de conexão com servidor Hotmail
//        props.put("mail.transport.protocol", "smtp");
//        props.put("mail.smtp.host", "smtp.live.com");
//        props.put("mail.smtp.socketFactory.port", "587");
//        props.put("mail.smtp.socketFactory.fallback", "false");
//        props.put("mail.smtp.starttls.enable", "true");
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.port", "587");

        //        Parâmetros de conexão com servidor Gmail
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myMail, myPass);
            }
        });

//        Ativa Debug para sessão
        session.setDebug(true);

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myMail)); // Remetente

            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destiny.trim())); // Destinatário(s)
            message.setSubject(subject);// Assunto
            message.setText(messageBody.concat("\n\n Att DOTAPIRULITO \nContato - alnsoftware@hotmail.com"));
//           Método para enviar a mensagem criada
            Transport.send(message);

            LOGGER.info("Class MailConfig : Method sendMail() -> END");

        } catch (MessagingException e) {
            LOGGER.error("Class MailConfig : Method sendMail() -> ERROR");
            throw new RuntimeException(e);
        }
    }


    /**
     * Realiza o envio do e-mail com anexo de acordo com a configuracao, utilizando os parametros informados.
     * @author zeck
     * @param  destiny -> Destinatario do e-mail.
     * @param  subject -> Assunto do e-mail.
     * @param messageBody -> Corpo do e-mail com o conteúdo a ser enviado.
     * @param descriptionFile -> Descrição do anexo.
     * @param pathFile -> Caminho do arquivo a ser enviado.
     * @since 10-02-2021
     * @see com.example.dota.service.SendMailService
     */
    public void appendMail(String destiny, String subject, String messageBody, String descriptionFile, String pathFile) {

        LOGGER.info("Class MailConfig : Method sendMail() -> START");

        Properties props = new Properties();
//        Parâmetros de conexão com servidor Gmail
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myMail, myPass);
            }
        });

//        Ativa Debug para sessão
        session.setDebug(true);

        try {

            // Cria parte injetavel no email
            MimeBodyPart mimeBodyPart1 = new MimeBodyPart();
            MimeBodyPart mimeBodyPart2 = new MimeBodyPart();

            // Cria parte final que recebe as partes injetaveis
            Multipart multipart = new MimeMultipart();

            // Prepara o arquivo para o formato ideal de envio como anexo
            FileDataSource fileDataSource = new FileDataSource(pathFile);

            // Prepara a mensagem para o formato ideal de envio
            Message message = new MimeMessage(session);

            // Remetente
            message.setFrom(new InternetAddress(myMail));

            // Destinatário(s)
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destiny.trim()));

            // Assunto
            message.setSubject(subject);

            // Adicionando mensagem em uma parte do e-mail
            mimeBodyPart1.setText(messageBody.concat("\n\n Att DOTAPIRULITO \nContato - alnsoftware@hotmail.com"));

            // Adicionando anexo em outra parte do e-mail
            mimeBodyPart2.setDataHandler(new DataHandler(fileDataSource));

            // Adicionando nome do anexo na mesma parte em que o anexo foi adicionado
            mimeBodyPart2.setFileName(fileDataSource.getName());

            // Adicionando as partes no multipart principal
            multipart.addBodyPart(mimeBodyPart1);
            multipart.addBodyPart(mimeBodyPart2);

            // Adicionando o multipart principal ao conteudo completo do e-mail
            message.setContent(multipart);

//           Método para enviar a mensagem criada
            Transport.send(message);

            LOGGER.info("Class MailConfig : Method sendMail() -> END");

        } catch (MessagingException e) {
            LOGGER.error("Class MailConfig : Method sendMail() -> ERROR");
            throw new RuntimeException(e);
        }
    }


}
