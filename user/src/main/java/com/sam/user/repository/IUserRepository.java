package com.sam.user.repository;

import com.sam.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User,Integer> { //Herency of library with methods
}
