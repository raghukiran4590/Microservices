package com.cbrk.hotel.micro.service.services.impl;

import com.cbrk.hotel.micro.service.entities.Hotel;
import com.cbrk.hotel.micro.service.repositories.HotelRepository;
import com.cbrk.hotel.micro.service.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
    public Optional<Hotel> findHotel(String Id) {
        return hotelRepository.findById(Id);
//                .orElseThrow(() ->
//                new ResourceNotFoundException("User with the given Id is not found "+Id)
//                );
    }
}
