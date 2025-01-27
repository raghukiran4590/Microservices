package com.cbrk.hotel.micro.service.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/staffs")
public class StaffController {

    //Get All Staff
    @PreAuthorize("hasAuthority('SCOPE_internal') || hasAuthority('Admin')")
    @GetMapping
    public ResponseEntity<List<String>> getAllStaff() {
        List<String> allStaff = Arrays.asList("Ram", "Shyam", "Krishna","Lakshman");
        return new ResponseEntity<>(allStaff, HttpStatus.OK);
    }

}
