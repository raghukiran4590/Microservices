package com.cbrk.micro.service.services.impl;

import com.cbrk.micro.service.entities.Hotel;
import com.cbrk.micro.service.entities.Rating;
import com.cbrk.micro.service.entities.User;
import com.cbrk.micro.service.exceptions.ResourceNotFoundException;
import com.cbrk.micro.service.external.services.HotelService;
import com.cbrk.micro.service.external.services.RatingService;
import com.cbrk.micro.service.repository.UserRepository;
import com.cbrk.micro.service.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelService hotelService;

    @Autowired
    private RatingService ratingService;

//    RestClient restClient = RestClient.create();

//    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User saveUser(User user) {
        String randomUUID = UUID.randomUUID().toString();
        user.setUserId(randomUUID);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        //Implement Get Ratings for all Users using WebClient
        return userRepository.findAll();
    }

    @Override
    public User findUser(String UserId) {
        User user1 = userRepository.findById(UserId).orElseThrow(() ->
                new ResourceNotFoundException("User with the given Id is not found " + UserId));

        ArrayList<Rating> ratingsforUser = ratingService.getRatingsforUser(user1.getUserId());
        log.info("Rating Micro Service Called");
        List<Rating> ratingsWithHotels = ratingsforUser.stream().peek(rating -> {
            Hotel hotelById = hotelService.getHotelById(rating.getHotelId());
            log.info("Hotel Micro Service Called");
            rating.setHotel(hotelById);
        }).toList();
        user1.setRatings(ratingsWithHotels);
        return  user1;
    }
}
