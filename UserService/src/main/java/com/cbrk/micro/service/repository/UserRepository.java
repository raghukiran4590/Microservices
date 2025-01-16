package com.cbrk.micro.service.repository;

import com.cbrk.micro.service.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

}
