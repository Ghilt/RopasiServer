package app.controller;

import app.model.GameState;
import app.model.Move;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class SelectMoveController {

    private GameState state;

    public SelectMoveController(GameState state) {
        this.state = state;
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.registerCustomEditor(Move.class, new MoveEnumConverter());
    }

    @RequestMapping(value = "/selectMove", method = RequestMethod.POST)
    public RedirectView makeMove(@RequestParam(value = "playerId") int playerId, @RequestParam(value = "move") Move move) {
        state.playerExecuteMove(playerId, move);
        return new RedirectView("result");
    }
}