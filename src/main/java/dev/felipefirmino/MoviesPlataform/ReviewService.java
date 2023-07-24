package dev.felipefirmino.MoviesPlataform;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ReviewService {
    @Autowired
    ReviewRepository reviewRepository;
    @Autowired
    MongoTemplate mongotemplate;
    public Review addReview(String reviewbody, String imdbID){
      Review review = reviewRepository.insert(new Review(reviewbody, LocalDateTime.now(),LocalDateTime.now()));
      //this block off code updates de array of reviews inside the database using template
      mongotemplate.update(Movie.class)
              .matching(Criteria.where("imdbId").is(imdbID))
              .apply(new Update().push("reviewIds").value(review))
              .first();

      return review;
    }
}
