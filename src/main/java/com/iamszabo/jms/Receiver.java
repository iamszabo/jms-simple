package com.iamszabo.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

   @JmsListener(destination = "mailbox-destination")
   public void receiveMessage(String message) {
      System.out.println(message);
   }
}
