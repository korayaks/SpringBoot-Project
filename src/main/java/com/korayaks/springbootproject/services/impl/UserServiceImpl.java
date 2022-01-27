package com.korayaks.springbootproject.services.impl;

import com.korayaks.springbootproject.entity.User;
import com.korayaks.springbootproject.repos.UserRepository;
import com.korayaks.springbootproject.services.UserService;
import com.korayaks.springbootproject.utils.dtos.UserCreateDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Configurable
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<User> getUsersByFirstNameAndLastName(String firstName, String lastName) {
        return userRepository.findByFirstNameOrLastName(firstName, lastName);
    }

    @Override
    public User createUser(UserCreateDto userCreateDto) {
        User user = modelMapper.map(userCreateDto, User.class);

        return userRepository.save(user);
    }
}
