package com.cbrk.rating.micro.service.repository;

import com.cbrk.rating.micro.service.entities.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository extends MongoRepository<Rating, String> {
    
}
