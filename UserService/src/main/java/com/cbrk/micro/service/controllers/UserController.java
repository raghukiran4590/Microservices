package com.cbrk.micro.service.controllers;

import com.cbrk.micro.service.entities.User;
import com.cbrk.micro.service.services.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    //Create User
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User user1 = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }

//    int retryCount = 1;
    //Get Single User
    @GetMapping({"/{userId}"})
//    @CircuitBreaker(name = "ratingHotelBreaker", fallbackMethod = "ratingHotelFallBack")
//    @Retry(name = "ratingHotelRetryService", fallbackMethod = "ratingHotelFallBack")
    @RateLimiter(name="userRateLimiter", fallbackMethod = "ratingHotelFallBack")
    public ResponseEntity<User> getSingleUser(@PathVariable String userId) {
        log.info("Get Single User Handler Controller");
//        retryCount++;
//        log.info("Retry Count {}", retryCount);
        User user = userService.findUser(userId);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    //Get All Users
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> allUsers = userService.getAllUsers();
        return ResponseEntity.ok(allUsers);
    }

    public ResponseEntity<User> ratingHotelFallBack(String userId, Exception ex) {
        log.info("Fallback is executed because the service is currently down"+ex.getMessage());
        User dummy = User.builder()
                .email("dummy.user@gmail.com")
                .name("Dummy")
                .about("This dummy user is created because the service is down")
                .userId("12345")
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(dummy);
    }


}
