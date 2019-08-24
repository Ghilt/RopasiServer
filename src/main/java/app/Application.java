package app;

import app.model.Move;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

// https://spring.io/guides/gs/rest-service/
// https://machiel.me/post/java-enums-as-request-parameters-in-spring-4/
// https://stackoverflow.com/questions/12893760/spring-cannot-find-bean-xml-configuration-file-when-it-does-exist

@SpringBootApplication
public class Application {

    // Most certainly not the way to actually handle data on a server, should probably use beans somehow
    public static HashMap<Integer, Move> players = new HashMap<Integer, Move>();

    static {
        players.put(1, null);
        players.put(2, null);
    }

    public static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        // See beans.xml
        // ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        SpringApplication.run(Application.class, args);
    }

    public static void playerExecuteMove(int playerId, Move move) {
        players.put(playerId, move);
        Application.log.info("player " + playerId + " moved. player 1:" + players.get(1) + ", player 2:" + players.get(2));
    }

    public static Move getPlayerMove(int playerId) {
        if (playerId != 1 && playerId != 2) throw new IllegalArgumentException("Invalid playerId: " + playerId);
        return players.get(playerId);
    }

    public static Set<Integer> getPlayers() {
        return players.keySet();
    }
}