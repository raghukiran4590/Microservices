package com.cbrk.micro.service;

import com.cbrk.micro.service.entities.Rating;
import com.cbrk.micro.service.external.services.RatingService;
import com.netflix.discovery.converters.Auto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

@Slf4j
@SpringBootTest
class UserServiceApplicationTests {

	@Autowired
	private RatingService ratingService;

	@Test
	void contextLoads() {
		System.out.println("Test Passed");
	}

	@Test
	void createRating() {
		log.info("Creating Rating");
		Rating rating = Rating.builder().userId("6c961abb-a2e7-4aaf-8012-7f9c179e3aa8").hotelId("98893ec6-7773-4c5e-b65c-26c0d70b786a").rating(7).feedback("Average Hotel").build();
		ResponseEntity<Rating> rating1 = ratingService.createRating(rating);
//		Rating body1 = rating1.getBody();
//		HttpStatusCode code = rating1.getStatusCode();
		log.info("Create Rating Test Passed");
	}

}
