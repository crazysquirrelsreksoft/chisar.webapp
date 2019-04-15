package web_appication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import web_appication.services.TripListService;

@Controller
public class mainPageController {

    @Autowired
    private TripListService tripListService;

//    @GetMapping("/homepage")
//    public String getMainPage(Model model){
//        return "mainPage";
//    }

    @GetMapping("/mainPage")
    public  String getMainPage(Model model){
        model.addAttribute("tripItemList", tripListService.getTripList());
        return "BootStrapPage";
    }

}
