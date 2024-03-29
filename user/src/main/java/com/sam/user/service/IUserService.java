package com.sam.user.service;

import com.sam.user.model.User;

import java.util.*;

public interface IUserService {
    List<User> findByStatus(String status);

    Optional<User> findById(Integer id);

    User create(User user);

    User update(User user);

    void delete(Integer id);

}
