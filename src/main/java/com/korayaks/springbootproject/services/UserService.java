package com.korayaks.springbootproject.services;

import com.korayaks.springbootproject.entity.User;
import com.korayaks.springbootproject.utils.dtos.UserCreateDto;

import java.util.List;

public interface UserService {
    List<User> getUsersByFirstNameAndLastName(String firstName, String lastName);

    User createUser(UserCreateDto userCreateDto);
}
