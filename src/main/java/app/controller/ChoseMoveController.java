package app.controller;

import app.Application;
import app.model.Move;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class ChoseMoveController {

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.registerCustomEditor(Move.class, new MoveEnumConverter());
    }

    @RequestMapping(value = "/choseMove", method = RequestMethod.POST)
    public RedirectView makeMove(@RequestParam(value = "playerId") int playerId, @RequestParam(value = "move") Move move) {
        Application.playerExecuteMove(playerId, move);
        return new RedirectView("result");
    }
}