package com.iamszabo.jms.receiver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;

@SpringBootApplication
@EnableJms
public class Receiver {

   @JmsListener(destination = "topic")
   public void receiveMessage(String message) {
      System.out.println("Message has been received" + message);
   }

   public static void main(String[] args) {
      SpringApplication.run(Receiver.class, args);
   }
}
