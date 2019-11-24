package com.cko.sampleSpringProject.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class FilmController {

    @GetMapping("/all")
    public String showFilms(){
        return "allFilms";
    }

    @GetMapping("/create")
    public String createFilms(){
        return "createFilms";
    }

    @GetMapping("/edit")
    public String editFilms(){
        return "editFilms";
    }
}
