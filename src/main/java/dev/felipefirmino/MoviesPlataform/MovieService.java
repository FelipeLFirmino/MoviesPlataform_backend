package dev.felipefirmino.MoviesPlataform;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;


@Service
public class MovieService  {
    @Autowired
    public MovieRepository repository;


    public List<Movie> allMovies(){
       return repository.findAll();
   }
   //the Optional here means that the movie may not be found, so the return can be null or a movie
   public Optional<Movie> GetOneMovie(String imdbId){
     return repository.findByImdbId(imdbId);
   };
}
