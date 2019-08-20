package app.controller;

import app.model.Move;
import app.model.RpsMove;
import org.springframework.http.MediaType;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@RestController
public class RpsMoveController {

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.registerCustomEditor(Move.class, new MoveEnumConverter());
    }

    @RequestMapping(value = "/rpsmove", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public RpsMove makeMove(@RequestParam(value = "move") Move move) {
        return new RpsMove(1, move);
    }
}