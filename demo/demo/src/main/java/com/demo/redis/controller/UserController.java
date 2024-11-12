package com.demo.redis.controller;

import com.demo.redis.model.User;
import com.demo.redis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("id/{userId}")
    public ResponseEntity<?> getJournalEntryById(@PathVariable String userId) {

        User user = userService.findByUserId(userId);

        if (user!=null) {
                return new ResponseEntity<>(user, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
