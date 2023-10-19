package dev.weilee.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public ResponseEntity getMovies() {
        return ResponseHandler.generateResponse(movieService.findAllMovies(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity getSingleMovie(@PathVariable String id){
        return ResponseHandler.generateResponse(movieService.findMovieById(new ObjectId(id)), HttpStatus.OK);
    }
}