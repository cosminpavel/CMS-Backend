package com.ubb.cms.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Marius Adam
 */
public class CliClientMain {
    public static void main(String[] args) throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/spring-client.xml");
        CmsServiceClient client = applicationContext.getBean(CmsServiceClient.class);
        try {

            String user = "world";
            if (args.length > 0) {
                user = args[0]; /* Use the arg as the name to greet if provided */
            }
            client.greet(user);

            System.out.println("All users with blocking call: ");
            client.getUsers().forEach(System.out::println);
            System.out.println("===========================");

            System.out.println("All editions: ");
            client.getEditions().forEach(System.out::println);
            System.out.println("===========================");

            System.out.println("All users using a response observer: ");
            client.getUsersAsync(System.out::println).await();
            System.out.println("===========================");

        } finally {
            client.shutdown();
        }
    }
}
