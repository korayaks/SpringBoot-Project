package com.korayaks.springbootproject.services.impl;

import com.korayaks.springbootproject.entity.User;
import com.korayaks.springbootproject.repos.UserRepository;
import com.korayaks.springbootproject.services.UserService;
import com.korayaks.springbootproject.utils.dtos.UserCreateDto;
import com.korayaks.springbootproject.utils.dtos.UserUpdateDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public User updateUser(UserUpdateDto userUpdateDto, String id) {
        Optional x = userRepository.findById(id);
        if (x == null) {
            throw new RuntimeException("this user does not exist!");
        }
        User existUser = modelMapper.map(x, User.class);
        existUser.setId(id);
        existUser.setFirstName(userUpdateDto.getFirstName());
        existUser.setLastName(userUpdateDto.getLastName());
        existUser.setAddress(userUpdateDto.getAddress());
        existUser.setAge(userUpdateDto.getAge());
        userRepository.save(existUser);
        return existUser;
    }
}
