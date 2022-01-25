package com.korayaks.springbootproject.controller;

import com.korayaks.springbootproject.entity.User;
import com.korayaks.springbootproject.repos.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Calendar;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserRepository userRepository;

    @PostConstruct
    public void init() {
        User user = new User();
        user.setName("burak koray");
        user.setSurname("aksoy");
        user.setAddress("istanbul");
        user.setBirthDate(Calendar.getInstance().getTime());
        user.setId("K0001");
        userRepository.save(user);
    }

    @GetMapping("/{search}")
    public ResponseEntity<List<User>> getUser(@PathVariable String search) {

        return ResponseEntity.ok(userRepository.findByNameLikeOrSurnameLike(search, search));
    }

}
