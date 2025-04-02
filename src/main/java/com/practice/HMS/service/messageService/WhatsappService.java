package com.practice.HMS.service.messageService;

import com.practice.HMS.interfaces.NotificationService;

public class WhatsappService implements NotificationService {


    @Override
    public void sendNotification() {
        System.out.print("Whatsapp notifiaction ");
    }
}
