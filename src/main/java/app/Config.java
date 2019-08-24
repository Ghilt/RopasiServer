package app;

import app.model.GameState;
import app.model.Move;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

@Configuration
@ComponentScan(basePackageClasses = GameState.class)
public class Config {

    @Bean
    public HashMap<Integer, Move> getState() {
        // Only support 2 players.
        HashMap<Integer, Move> state = new HashMap<Integer, Move>();
        state.put(1, null);
        state.put(2, null);
        return state;
    }
}