package com.iamszabo.jms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.util.FileSystemUtils;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import java.io.File;

@SpringBootApplication
@EnableJms
public class Application {

   public static void main(String[] args) {
      FileSystemUtils.deleteRecursively(new File("activemq-data"));
      ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

      MessageCreator messageCreator = new MessageCreator() {
         @Override
         public Message createMessage(Session session) throws JMSException {
            return session.createTextMessage("ping!");
         }
      };
      JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);
      System.out.println("Sending a new message.");
      jmsTemplate.send("mailbox-destination", messageCreator);
   }
}
