package com.cbrk.rating.micro.service.controller;

import com.cbrk.rating.micro.service.entity.Rating;
import com.cbrk.rating.micro.service.service.RatingService;
import org.bson.types.ObjectId;
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
    @PostMapping("/create-rating")
    public ResponseEntity<?> createRating(@RequestBody Rating rating) {
//        return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.saveRating(rating));
        return new ResponseEntity<>(ratingService.saveRating(rating), HttpStatus.CREATED);
    }

    //Get All Ratings
    @GetMapping
    public ResponseEntity<?> getAllRatings() {
        List<Rating> ratingsList = ratingService.getAllRatings();
        return new ResponseEntity<>(ratingsList, HttpStatus.OK);
    }

    //Get Single Rating
    @GetMapping({"/{Id}"})
    public ResponseEntity<Optional<Rating>> getSingleRating(@PathVariable ObjectId Id) {
        Optional<Rating> ratingById = ratingService.getRatingById(Id);
        return new ResponseEntity<>(ratingById, HttpStatus.OK);
    }

    //Get Ratings by UserId
    @GetMapping({"/users/{userId}"})
    public ResponseEntity<List<Rating>> getRatingsByUserId(@PathVariable String userId) {
        return ResponseEntity.ok(ratingService.getRatingsByUserId(userId));
    }

    //Get Ratings by HotelId
    @GetMapping({"/hotels/{hotelId}"})
    public ResponseEntity<List<Rating>> getRatingsByHotelId(@PathVariable String hotelId) {
        List<Rating> ratingsByHotelId = ratingService.getRatingsByHotelId(hotelId);
        return new ResponseEntity<>(ratingsByHotelId, HttpStatus.OK);
    }

}
