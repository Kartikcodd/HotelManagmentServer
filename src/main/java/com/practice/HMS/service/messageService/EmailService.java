package com.practice.HMS.service.messageService;

import com.practice.HMS.interfaces.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailService implements NotificationService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void sendNotification() {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

//        simpleMailMessage.setTo("kartikk.panchal@gmail.com");
        simpleMailMessage.setTo("vijaydas813086@gmail.com");
        simpleMailMessage.setSubject("Test Email service");
        simpleMailMessage.setText("hello erevey one");
        javaMailSender.send(simpleMailMessage);
                System.out.print("Email notification");
    }



}
