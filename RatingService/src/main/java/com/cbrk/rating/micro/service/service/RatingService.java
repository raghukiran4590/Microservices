package com.cbrk.rating.micro.service.service;

import com.cbrk.rating.micro.service.entity.Rating;
import com.cbrk.rating.micro.service.repository.RatingRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Service
public class RatingService implements Serializable {

    @Autowired
    private RatingRepository ratingRepository;

    @Transactional
    public Rating saveRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    public List<Rating> getAllRatings() {
        return ratingRepository.findAll();
    }

    public List<Rating> getRatingsByUserId(String userId) {
        return ratingRepository.getRatingsByUserId(userId);
    }

    public List<Rating> getRatingsByHotelId(String hotelId) {
        return ratingRepository.getRatingsByHotelId(hotelId);
    }

    public Optional<Rating> getRatingById(ObjectId Id) {
        return ratingRepository.findById(Id);
    }
}
