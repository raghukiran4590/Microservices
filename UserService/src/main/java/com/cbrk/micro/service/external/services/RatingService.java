package com.cbrk.micro.service.external.services;

import com.cbrk.micro.service.entities.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.ArrayList;
import java.util.List;

@Service
@FeignClient(name = "RATINGSERVICE")
public interface RatingService {

    @GetMapping("/ratings/users/{userId}")
    ArrayList<Rating> getRatingsforUser(@PathVariable("userId") String userId);

    @PostMapping("/ratings/create-rating")
    ResponseEntity<Rating> createRating(Rating rating);

    @PutMapping("/ratings/update-rating/{Id}")
    Rating updateRating(@PathVariable String Id, Rating rating);

}
