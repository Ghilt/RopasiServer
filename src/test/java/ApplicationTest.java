import app.Application;
import app.Config;
import app.controller.SelectPlayerController;
import app.model.GameState;
import app.model.Move;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ApplicationTest {

    @Autowired
    private SelectPlayerController controller;

    @Test
    public void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }

    @Test
    public void testIoC() throws Exception {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        GameState state = context.getBean("gameState", GameState.class);
        state.playerExecuteMove(1, Move.SCISSORS);
        assertEquals(Move.SCISSORS, state.getPlayerMove(1));
        assertEquals(null, state.getPlayerMove(2));
    }
}
