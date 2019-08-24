package app;

import app.model.Move;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// https://spring.io/guides/gs/rest-service/
// https://machiel.me/post/java-enums-as-request-parameters-in-spring-4/
// https://stackoverflow.com/questions/12893760/spring-cannot-find-bean-xml-configuration-file-when-it-does-exist

@SpringBootApplication
public class Application {

    // Most certainly not the way to actually handle data on a server
    public static Move p1Move = null;
    public static Move p2Move = null;

    public static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        // See beans.xml
        // ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        SpringApplication.run(Application.class, args);
    }
}