package com.cbrk.hotel.micro.service.services;

import com.cbrk.hotel.micro.service.entities.Hotel;

import java.util.List;
import java.util.Optional;

public interface HotelService {

    //Create New Hotel
    Hotel saveHotel(Hotel hotel);

    //Get all hotels
    List<Hotel> getAllHotels();

    //Find Hotel by ID
    Optional<Hotel> findHotel(String Id);

}
