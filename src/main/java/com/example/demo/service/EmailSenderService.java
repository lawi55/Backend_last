package com.example.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import javax.mail.NoSuchProviderException;
import javax.mail.Provider;
import javax.mail.Session;
import java.net.Authenticator;
import java.util.Properties;

@Service
public class EmailSenderService {

    @Autowired
     JavaMailSender javaMailSender;

    @Bean
    public JavaMailSenderImpl mailSender() {
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost("smtp.gmail.com");
        javaMailSender.setPort(587);


        javaMailSender.setUsername("verifapp.tun@gmail.com");
        javaMailSender.setPassword("cstsngpckivommfj   ");
        javaMailSender.setProtocol("SMTP");
        Properties props = javaMailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");
        return javaMailSender;
    }

    public void sendSimpleEmail(String toEmail,String body) throws NoSuchProviderException {



        try{
            Properties props = new Properties();
            props.setProperty("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.auth" , "true");
            props.put("mail.debug", "true");
            props.put("mail.transport.protocol", "smtp");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable","true");


            Session session = Session.getDefaultInstance(props);



            session.setDebug(true);
        SimpleMailMessage message= new SimpleMailMessage();

        message.setFrom("verifapp.tun@gmail.com");
        message.setTo(toEmail);
        message.setText(body);
        message.setSubject("Bienvenue à Fidelys");

        javaMailSender.send(message);
        System.out.println("mail send..");
    }catch(Exception e){throw e;}}
}
