package app.controller;

import app.Application;
import app.model.GameState;
import app.model.Player;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SelectPlayerController {

    private GameState state;

    public SelectPlayerController(GameState state) {
        this.state = state;
    }

    @GetMapping("/selectPlayer")
    public String getSelectPlayer(Model model) {
        model.addAttribute("selectPlayer", new Player());
        model.addAttribute("players", state.getPlayers());
        return "selectPlayer";
    }

    @PostMapping("/selectPlayer")
    public String postSelectPlayer(@ModelAttribute Player selectPlayer) {
        Application.log.info("Post: selectPlayer: " + selectPlayer.getPlayerId());
        return "selectMove";
    }
}