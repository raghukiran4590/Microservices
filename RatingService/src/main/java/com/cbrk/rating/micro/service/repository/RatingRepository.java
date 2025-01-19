package com.cbrk.rating.micro.service.repository;

import com.cbrk.rating.micro.service.entity.Rating;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends MongoRepository<Rating, ObjectId> {

    //Custom Finder Methods
    List<Rating> getRatingsByUserId(String userId);
    List<Rating> getRatingsByHotelId(String hotelId);

}
