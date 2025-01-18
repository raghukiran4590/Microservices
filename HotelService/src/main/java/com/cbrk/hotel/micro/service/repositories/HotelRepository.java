package com.cbrk.hotel.micro.service.repositories;

import com.cbrk.hotel.micro.service.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, String> {
}
