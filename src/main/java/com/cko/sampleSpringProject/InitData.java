package com.cko.sampleSpringProject;

import com.cko.sampleSpringProject.dao.FilmDAO;
import com.cko.sampleSpringProject.model.Authority;
import com.cko.sampleSpringProject.model.Film;
import com.cko.sampleSpringProject.model.User;
import com.cko.sampleSpringProject.service.AuthorityService;
import com.cko.sampleSpringProject.service.SMSCService;
import com.cko.sampleSpringProject.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InitData {

    @Autowired
    UserService userService;

    @Autowired
    AuthorityService authorityService;

    @Autowired
    SMSCService smscSender;

    @Autowired
    FilmDAO filmDAO;


    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public void initData() {

        initFilms();
        initUserAndRoles();


    }

    private void initFilms() {
        Film film = new Film("Начало",9,16);
        filmDAO.save(film);
        Film film1 = new Film("Зеленая миля",10,18);
        filmDAO.save(film1);
        Film film2 = new Film("Заводной апельсин",10,18);
        filmDAO.save(film2);
        Film film3 = new Film("Космическая одиссея 2001",10,18);
        filmDAO.save(film3);

    }

    private void initUserAndRoles(){
        Authority adminAuthority = new Authority("ROLE_ADMIN");
        Authority userAuthority = new Authority("ROLE_USER");
        authorityService.insert(adminAuthority);
        authorityService.insert(userAuthority);

        List<Authority> authorities = new ArrayList<Authority>();
        authorities.add(adminAuthority);
        userService.insert(new User("1@mail.ru",bCryptPasswordEncoder.encode("1"), authorities));


    }
}
