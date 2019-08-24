package app.controller;

import app.Application;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResultController {
    @RequestMapping("/result")
    public String home() {

        if (Application.p1Move == null || Application.p2Move == null) {
            return "⌛ Waiting for the other player. You should spam f5.";
        } else {
            Boolean result = Application.p1Move.isDefeatedBy(Application.p2Move);
            StringBuilder builder = new StringBuilder();
            if (result == null) {
                builder.append("\uD83D\uDE11 It's a draw")
                        .append("\nBoth players chose: ")
                        .append(Application.p1Move);
            } else {
                builder.append("\uD83C\uDFC6 Player ")
                        .append(result ? 1 : 2)
                        .append(" wins!\n")
                        .append(Application.p1Move)
                        .append(result ? " > " : " < ")
                        .append(Application.p2Move);
            }
            return builder.toString();
        }
    }
}
