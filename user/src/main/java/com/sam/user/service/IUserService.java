package com.sam.user.service;

import com.sam.user.model.User;

import java.util.*;

public interface IUserService {
    List<User> findAll();

    Optional<User> findById(Long id);

    User create(User user);

    User update(User user);

    void delete(Long id);

}
