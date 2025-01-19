package com.cbrk.rating.micro.service.service.impl;

import com.cbrk.rating.micro.service.entities.Rating;
import com.cbrk.rating.micro.service.repository.RatingRepository;
import com.cbrk.rating.micro.service.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    @Override
    public Rating saveRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getAllRatings() {
        return ratingRepository.findAll();
    }

    @Override
    public List<Rating> getRatingsByUserId(String userId) {
        return ratingRepository.getRatingsByUserId(userId);
    }

    @Override
    public List<Rating> getRatingsByHotelId(String hotelId) {
        return ratingRepository.getRatingsByHotelId(hotelId);
    }

    @Override
    public Optional<Rating> getRatingById(String ratingId) {
        return ratingRepository.findById(ratingId);
    }
}
