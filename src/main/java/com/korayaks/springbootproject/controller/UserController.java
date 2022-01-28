package com.korayaks.springbootproject.controller;

import com.korayaks.springbootproject.entity.User;
import com.korayaks.springbootproject.services.UserService;
import com.korayaks.springbootproject.utils.dtos.UserCreateDto;
import com.korayaks.springbootproject.utils.dtos.UserUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@Transactional
@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/{search}")
    public ResponseEntity<List<User>> getUser(@PathVariable String search) {

        return ResponseEntity.ok(userService.getUsersByFirstNameAndLastName(search, search));
    }

    @PostMapping("/createUser")
    public ResponseEntity<?> createUser(@Valid @RequestBody UserCreateDto userCreateDto) {

        return ResponseEntity.ok(userService.createUser(userCreateDto));
    }

    @PutMapping("/updateUser/{id}")
    public ResponseEntity<?> updateUser(@Valid @RequestBody UserUpdateDto userUpdateDto,@PathVariable String id){
        return ResponseEntity.ok(userService.updateUser(userUpdateDto, id));
    }

}
