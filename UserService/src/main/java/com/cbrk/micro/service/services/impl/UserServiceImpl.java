package com.cbrk.micro.service.services.impl;

import com.cbrk.micro.service.entities.Hotel;
import com.cbrk.micro.service.entities.Rating;
import com.cbrk.micro.service.entities.User;
import com.cbrk.micro.service.exceptions.ResourceNotFoundException;
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

    RestClient restClient = RestClient.create();

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
        //Fetch Ratings by User ID with a REST API call
//        URI url = URI.create("http://localhost:9092/ratings/users/6c961abb-a2e7-4aaf-8012-7f9c179e3aa8");
//        ArrayList body = restClient.get().uri(url).retrieve().body(ArrayList.class);
//        String url = "http://localhost:9092/ratings/users/{userId}";
//        Removing Host name and Port Number for Microservices using @LoadBalanced
//        String url = "http://RATINGSERVICE/ratings/users/6c961abb-a2e7-4aaf-8012-7f9c179e3aa8";
//        String userId = user1.getUserId();
//        URI uri = UriComponentsBuilder.fromUriString(url).buildAndExpand(userId).toUri();
//        Rating[] ratingOfUserList = restTemplate.getForObject(uri, Rating[].class);
//        ResponseEntity<Rating[]> responseEntity = restTemplate.getForEntity(url, Rating[].class);
//        log.info("Response Status Code {} ", responseEntity.getStatusCode());
//        List<Rating> ratings = Arrays.stream(responseEntity.getBody()).toList();
//        user1.setRatings(ratings);
        /*assert ratingOfUserList != null;
        List<Rating> ratings = Arrays.stream(ratingOfUserList).toList();

//        assert ratings != null;
        List<Rating> ratingList = ratings.stream().peek(rating -> {
            // API call to fetch hotel details
            String hotelUrl = "http://HOTELSERVICE/hotels/"+rating.getHotelId();
            ResponseEntity<Hotel> hotelResponseEntity = restTemplate.getForEntity(hotelUrl, Hotel.class);
            Hotel hotel = hotelResponseEntity.getBody();
            log.info("Response Status Code : {}",hotelResponseEntity.getStatusCode());
            rating.setHotel(hotel);
        }).toList();

        user1.setRatings(ratingList);
         */
        return  user1;
    }
}
