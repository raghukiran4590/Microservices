package com.cbrk.hotel.micro.service.services.impl;

import com.cbrk.hotel.micro.service.entities.Hotel;
import com.cbrk.hotel.micro.service.exceptions.ResourceNotFoundException;
import com.cbrk.hotel.micro.service.repositories.HotelRepository;
import com.cbrk.hotel.micro.service.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public Hotel saveHotel(Hotel hotel) {
        String randomUUID = UUID.randomUUID().toString();
        hotel.setId(randomUUID);
        return hotelRepository.save(hotel);
    }


    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel findHotel(String Id) {
        return hotelRepository.findById(Id).orElseThrow(() ->
                new ResourceNotFoundException("Hotel not found with this ID "+Id));
    }
}
