package com.korayaks.springbootproject.services;

import com.korayaks.springbootproject.entity.User;
import com.korayaks.springbootproject.utils.dtos.UserCreateDto;
import com.korayaks.springbootproject.utils.dtos.UserUpdateDto;

import java.util.List;

public interface UserService {
    List<User> getUsersByFirstNameAndLastName(String firstName, String lastName);

    User createUser(UserCreateDto userCreateDto);

    User updateUser(UserUpdateDto userUpdateDto, String id);

    String deleteUser(String id);
}
