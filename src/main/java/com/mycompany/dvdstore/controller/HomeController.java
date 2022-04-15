package com.mycompany.dvdstore.controller;

import com.mycompany.dvdstore.entity.Movie;
import com.mycompany.dvdstore.form.MovieForm;
import com.mycompany.dvdstore.service.MovieServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping( "/movie" )
public class HomeController implements MovieControllerInterface {

    @Autowired
    private MovieServiceInterface movieServiceInterface;

    public MovieServiceInterface getMovieServiceInterface() {
        return movieServiceInterface;
    }

    public void setMovieServiceInterface( MovieServiceInterface movieServiceInterface ) {
        this.movieServiceInterface = movieServiceInterface;
    }

    @GetMapping( "/home" )
    public String displayHome( Model model ) {
        System.out.println( "La méthode display home a était invoqué" );
        model.addAttribute( "movies", movieServiceInterface.getMovieList() );
        return "dvdstore-home";
    }

    @GetMapping( "/add-movie-form" )
    public String displayMovieForm( @ModelAttribute MovieForm movie ) {
        System.out.println( "La méthode display Movie Form a était invoqué" );
        return "add-movie-form";
    }

}

