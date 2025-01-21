package com.cbrk.micro.service.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Hotel {

    private String id;
    private String name;
    private String location;
    private String about;

}
