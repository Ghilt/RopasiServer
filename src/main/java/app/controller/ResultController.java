package app.controller;

import app.Application;
import app.model.Move;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class ResultController {
    @RequestMapping("/result")
    public String result() {

        Move p1Move = Application.getPlayerMove(1);
        Move p2Move = Application.getPlayerMove(2);

        if (p1Move == null || p2Move == null) {
            return "⌛ Waiting for the other player. You should spam f5.";
        } else {
            Boolean result = p1Move.isDefeatedBy(p2Move);
            Application.log.info("Result: player 1:" + p1Move + ", player 2:" + p2Move + " Outcome: " + result);

            StringBuilder builder = new StringBuilder();
            if (result == null) {
                builder.append("\uD83D\uDE11 It's a draw")
                        .append("\nBoth players chose: ")
                        .append(p1Move);
            } else {
                builder.append("\uD83C\uDFC6 Player ")
                        .append(result ? 1 : 2)
                        .append(" wins!\n")
                        .append(p1Move)
                        .append(result ? " > " : " < ")
                        .append(p2Move);
            }
            return builder.toString();
        }
    }
}
