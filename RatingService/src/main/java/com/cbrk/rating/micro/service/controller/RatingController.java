package com.cbrk.rating.micro.service.controller;

import com.cbrk.rating.micro.service.entities.Rating;
import com.cbrk.rating.micro.service.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    //Create Rating
    @PostMapping
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating) {
        Rating rating1 = ratingService.saveRating(rating);
        return ResponseEntity.status(HttpStatus.CREATED).body(rating1);
    }

    //Get All Ratings
    @GetMapping
    public ResponseEntity<List<Rating>> getAllRatings() {
        List<Rating> allRatings = ratingService.getAllRatings();
        return ResponseEntity.ok(allRatings);
    }

    //Get Single Rating
    @GetMapping({"/{ratingId}"})
    public ResponseEntity<Optional<Rating>> getSingleRating(@PathVariable String ratingId) {
        Optional<Rating> ratingById = ratingService.getRatingById(ratingId);
        return ResponseEntity.ok(ratingById);
    }

    //Get Ratings by UserId
    @GetMapping({"/users/{userId}"})
    public ResponseEntity<List<Rating>> getRatingsByUserId(@PathVariable String userId) {
        List<Rating> ratingsByUserId = ratingService.getRatingsByUserId(userId);
        return ResponseEntity.ok(ratingsByUserId);
    }

    //Get Ratings by HotelId
    @GetMapping({"/hotels/{hotelId}"})
    public ResponseEntity<List<Rating>> getRatingsByHotelId(@PathVariable String hotelId) {
        List<Rating> ratingsByHotelId = ratingService.getRatingsByHotelId(hotelId);
        return ResponseEntity.ok(ratingsByHotelId);
    }

}
