package com.mycompany.dvdstore.controller;

import com.mycompany.dvdstore.service.MovieServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping( "/movie" )
public class MovieController implements MovieControllerInterface {

    @Autowired
    private MovieServiceInterface movieService;

    public MovieServiceInterface getMovieService() {
        return movieService;
    }

    public void setMovieService(MovieServiceInterface movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/{id}")
    public String displayMovieCard(@PathVariable( "id" ) long number, Model model){
        model.addAttribute( "movie", movieService.getMovieById( number ) );
        return "movie-details";
    }


//    public void addUsing() {
//        System.out.println("what is the movie name");
//        Scanner sc = new Scanner(System.in);
//        String name = sc.nextLine();
//        System.out.println("Enter the genre of the film ");
//        String gender = sc.nextLine();
//        Movie movie = new Movie();
//        movie.setTitel(name);
//        movie.setGenre(gender);
//        movieService.registerMovie(movie);
//    }

}
