package com.cbrk.rating.micro.service.service;

import com.cbrk.rating.micro.service.entities.Rating;

import java.util.List;
import java.util.Optional;

public interface RatingService {

    //Create New Rating
    Rating saveRating(Rating rating);

    //Get all Ratings
    List<Rating> getAllRatings();

    //Get Ratings by UserID
    List<Rating> getRatingsByUserId(String userId);

    //Get Ratings by HotelID
    List<Rating> getRatingsByHotelId(String hotelId);

    //Get Rating by ID
    Optional<Rating> getRatingById(String ratingId);

}
