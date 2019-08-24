package app.controller;

import app.Application;
import app.model.RpsMove;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ChosePlayerController {

    @GetMapping("/chosePlayer")
    public String greetingForm(Model model) {
        model.addAttribute("chosePlayer", new RpsMove());
        return "chosePlayer";
    }

    @PostMapping("/chosePlayer")
    public String greetingSubmit(@ModelAttribute RpsMove chosePlayer) {
        Application.log.info("logging " + chosePlayer.getPlayerId());
        return "choseMove";
    }
}