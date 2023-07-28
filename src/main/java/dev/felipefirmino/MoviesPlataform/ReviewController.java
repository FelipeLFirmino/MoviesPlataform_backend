package dev.felipefirmino.MoviesPlataform;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/reviews")
public class ReviewController {
    @Autowired
    ReviewService reviewService;
    @PostMapping
    public ResponseEntity<Review> addReview(@RequestBody Map<String, String> payload){
        return new ResponseEntity<Review>(reviewService.addReview(payload.get("reviewbody"), payload.get("imdbId")), HttpStatus.OK);
    }

}
