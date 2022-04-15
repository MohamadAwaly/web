package com.mycompany.dvdstore.controller;

import com.mycompany.dvdstore.entity.Movie;
import com.mycompany.dvdstore.service.MovieServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping( "/movie" )
public class MovieController implements MovieControllerInterface {

    @Autowired
    private MovieServiceInterface movieService;

    public MovieServiceInterface getMovieService() {
        return movieService;
    }

    public void setMovieService( MovieServiceInterface movieService ) {
        this.movieService = movieService;
    }

    @GetMapping( "/{id}" )
    public String displayMovieCard( @PathVariable( "id" ) long number, Model model ) {
        model.addAttribute( "movie", movieService.getMovieById( number ) );
        return "movie-details";
    }

    @PostMapping( "" )
    public String addMovie(@ModelAttribute Movie movie) {
        movieService.registerMovie( movie );
        return "movie-added";
    }
}



