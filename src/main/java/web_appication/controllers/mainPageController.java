package web_appication.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class mainPageController {

    @GetMapping("/homepage")
    public String getMainPage(Model model){
        return "mainPage";
    }

}
