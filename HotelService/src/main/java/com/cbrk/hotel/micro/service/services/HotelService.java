package com.cbrk.hotel.micro.service.services;

import com.cbrk.hotel.micro.service.entities.Hotel;

import java.util.List;

public interface HotelService {

    //Create New Hotel
    Hotel saveHotel(Hotel hotel);

    //Get all hotels
    List<Hotel> getAllHotels();

    //Find Hotel by ID
    Hotel findHotel(String Id);

}
