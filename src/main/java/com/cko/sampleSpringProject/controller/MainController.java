package com.cko.sampleSpringProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @GetMapping("/loginPage")
    public String showLoginPage(){
        return "login";
    }


    @GetMapping("/")
    public String showMainPage(){
        return "Mainpage";
    }

    @GetMapping("/game")
    public String showGamePage(){
        return "game";
    }

    @GetMapping("/test")
    public String testing(@RequestParam String name){
        System.out.println(name);
        return "test";
    }

//    @GetMapping("/test")
//    public String testing(){
//        return "test";
//    }


}
