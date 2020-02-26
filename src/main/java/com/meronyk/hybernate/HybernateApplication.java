package com.meronyk.hybernate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import javax.jws.soap.SOAPBinding;
import java.util.List;

@SpringBootApplication
public class HybernateApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(HybernateApplication.class, args);
            UserService userService = applicationContext.getBean(UserService.class);
            UserEntity user = userService.createUser("firstName1", "lastName1", "email1@example.com");
            UserEntity user1 = userService.createUser("firstName2", "lastName2", "email2@example.com");
        UserEntity user2 = userService.createUser("firstName3", "lastName2", "email3@example.com");
            System.out.println("Saved new user: " + user);
        System.out.println("-------Printing all users");
        List<UserEntity> j = userService.findAllUsers();
        for (UserEntity u : j)
        {
            System.out.println(u);
        }
            List<UserEntity> l = userService.findLastNameUsers("lastName2");
        System.out.println("-------Printing users that have lastname = lasName2");
            for (UserEntity u : l)
        {
            System.out.println(u);
        }
        System.out.println("-------Printing users that contain '2' in lastname or firstname ");
        List<UserEntity> k = userService.findPartUsers("2");
        for (UserEntity u : k)
        {
            System.out.println(u);
        }
	}

}
