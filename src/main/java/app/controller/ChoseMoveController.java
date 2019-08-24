package app.controller;

import app.Application;
import app.model.Move;
import org.springframework.http.MediaType;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@RestController
public class ChoseMoveController {

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.registerCustomEditor(Move.class, new MoveEnumConverter());
    }

    @RequestMapping(value = "/choseMove", method = RequestMethod.POST, produces = MediaType.APPLICATION_XHTML_XML_VALUE)
    public String makeMove(@RequestParam(value = "playerId") int playerId, @RequestParam(value = "move") Move move) {

        if (playerId == 1) {
            Application.p1Move = move;
        } else {
            Application.p2Move = move;
        }

        Application.log.info("player " + playerId + " moved. player 1:" + Application.p1Move + ", player 2:" + Application.p2Move);

        // Probably want to go to a page here which refreshes itself here when the other player has made their move
        if (Application.p1Move == null || Application.p2Move == null) {
            return "<xml>Waiting for other player</xml>";
        } else {
            Boolean result = Application.p1Move.isDefeatedBy(Application.p2Move);
            if (result == null) {
                return "<xml>It's a draw</xml>";
            } else if (result.equals(Boolean.TRUE)) {
                return "<xml>Player 1 wins!</xml>";
            } else {
                return "<xml>Player two wins!</xml>";
            }
        }
    }
}