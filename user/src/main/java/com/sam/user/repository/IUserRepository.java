package com.sam.user.repository;

import com.sam.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IUserRepository extends JpaRepository<User,Integer> {
    List<User> findByStatus(String status); //Herency of library with methods
}
