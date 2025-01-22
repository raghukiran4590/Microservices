package com.cbrk.micro.service.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Rating {

    private Object id;
    private String userId;
    private String hotelId;
    private int rating;
    private String feedback;
    private Hotel hotel;

}
