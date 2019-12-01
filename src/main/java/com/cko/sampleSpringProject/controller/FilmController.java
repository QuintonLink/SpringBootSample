package com.cko.sampleSpringProject.controller;

import com.cko.sampleSpringProject.dao.FilmDAO;
import com.cko.sampleSpringProject.model.Film;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class FilmController {
    @Autowired
    FilmDAO filmDAO;


    @GetMapping("/all")
    public ModelAndView showFilms(){

        ModelAndView model = new ModelAndView();
        model.setViewName("allFilms");
        List<Film> filmslist = filmDAO.findAll();
        model.addObject("films",filmslist);
        return model;
    }

    @GetMapping("/create")
    public String createFilms(){
        return "createFilms";
    }

    @GetMapping("/editFilms")
    public ModelAndView editFilms(@RequestParam long id){
        ModelAndView model = new ModelAndView();
        model.setViewName("editFilms");
        Film film = filmDAO.findFilmById(id);
        model.addObject("Film", film);
        return model;
    }

    @GetMapping("/testi")
    public ModelAndView test(){

        ModelAndView model = new ModelAndView();
        model.setViewName("testi");
        Film first = filmDAO.findFilmById(1);
        model.addObject("firstFilm", first);
        return model;
    }

    @PostMapping("/editFilms")
    public RedirectView editFilm(Film film) {
        filmDAO.save(film);
        return new RedirectView("/all");
    }

    @GetMapping("/deleteFilm")
    public RedirectView deleteFilm(@RequestParam long id) {
        filmDAO.deleteById(id);
        return new RedirectView("/all");
    }






}
