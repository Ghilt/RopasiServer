package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// https://spring.io/guides/gs/rest-service/
// https://machiel.me/post/java-enums-as-request-parameters-in-spring-4/
// https://stackoverflow.com/questions/12893760/spring-cannot-find-bean-xml-configuration-file-when-it-does-exist

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        // See beans.xml
        // ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        SpringApplication.run(Application.class, args);
    }
}