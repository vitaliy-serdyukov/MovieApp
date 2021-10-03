package controller;

import models.Movie;
import repository.DBManager;
import services.MovieService;
import org.springframework.web.bind.annotation.*;
import java.sql.Connection;
import java.util.ArrayList;

@RestController
public class MovieController {

  @GetMapping("/check")
  @ResponseBody
  public String checkConnection (){
    Connection connection = DBManager.getConnection();
    if (connection != null)
      return "Yeap - I made it to the DB!!!!!!";
    else return "Øv, øv og atter øv :-(";
  }


  @GetMapping("/")
  @ResponseBody
  public String welcomeMovieApp (){
    return "Welcome to our IMDB application!";
  }


  // f.ex. http://localhost:8282/getfirst?title=new
  @GetMapping("/getfirst")
  @ResponseBody
  public String getMoviesByTitle(@RequestParam String title){
    MovieService movieService = new MovieService();
    Movie movie = movieService.findMovie(title);
    return "Our first movie in this search is movie with \n" + movie.toString();
  }

  // http://localhost:8282/getrandom
  @GetMapping("/getrandom")
  @ResponseBody
  public String getMoviesByRandom() {
    MovieService movieService = new MovieService();
    Movie movie = movieService.findRadomMovie();
    return "Our random movie is " + movie.toString();
  }

  // http://localhost:8282/getTenSortByPopularity
  @GetMapping("/getTenSortByPopularity")
  @ResponseBody
  public String getTenMostPopular() {
    MovieService movieService = new MovieService();
    ArrayList<Movie> moviesTemp = movieService.findTop10();
    return "Our top 10 random movies are " + moviesTemp.toString();
  }



  // http://localhost:8282/howManyWonAnAward
  @GetMapping("/howManyWonAnAward")
  @ResponseBody
  public String getAllWithAwards() {
    MovieService movieService = new MovieService();
    return "The amount of movies with award is " + movieService.findAmountWithAward();
  }
}
