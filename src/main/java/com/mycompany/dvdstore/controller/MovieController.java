package com.mycompany.dvdstore.controller;

import com.mycompany.dvdstore.entity.Movie;
import com.mycompany.dvdstore.form.MovieForm;
import com.mycompany.dvdstore.service.MovieServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
/*
    @GetMapping( "/{id}" )
    public String displayMovieCard( @PathVariable( "id" ) long number, Model model ) {
        model.addAttribute( "movie", movieService.getMovieById( number ) );
        return "movie-details";
    }*/

    /*@PostMapping( "" )
    public String addMovie(@Valid @ModelAttribute MovieForm movieForm, BindingResult results) {
        if(results.hasErrors()){
            return "add-movie-form";
        } else {
            Movie movie = new Movie();
            movie.setTitel(movieForm.getTitel());
            movie.setGenre(movieForm.getGenre());
            movie.setDescription(movieForm.getDescription());
            movieService.registerMovie( movie );
            return "movie-added";
        }
    }*/
}



