package com.demo.redis.service;

import com.demo.redis.entity.UserEntity;
import com.demo.redis.model.User;
import com.demo.redis.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RedisService redisService;
    public User findByUserId(String userId) {

        User user=redisService.get(userId, User.class);
        if(user!=null){
            return user;
        }else{
            Optional<UserEntity> userEntity=userRepository.findById(userId);
            if(userEntity.isPresent()){
                user=new User();
                user.setUserId(userEntity.get().getUserId());
                user.setEmail(userEntity.get().getEmail());
                user.setName(userEntity.get().getName());
            }
        }

        return user;
    }


}
