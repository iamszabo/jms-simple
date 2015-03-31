package com.iamszabo.jms.sender;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

@SpringBootApplication
public class Sender {

   public static void main(String[] args) {
      ConfigurableApplicationContext context = SpringApplication.run(Sender.class, args);
      MessageCreator messageCreator = new MessageCreator() {
         @Override
         public Message createMessage(Session session) throws JMSException {
            return session.createTextMessage("dog!");
         }
      };
      JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);
      System.out.println("Sending a new message.");
      jmsTemplate.send("topic", messageCreator);
      System.out.println("Message has been sent.");
   }
}
