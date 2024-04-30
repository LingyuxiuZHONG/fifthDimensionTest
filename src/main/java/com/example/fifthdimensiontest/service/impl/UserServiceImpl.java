package com.example.fifthdimensiontest.service.impl;

import com.example.fifthdimensiontest.UserRepository;
import com.example.fifthdimensiontest.entity.Role;
import com.example.fifthdimensiontest.entity.RoleType;
import com.example.fifthdimensiontest.entity.User;
import com.example.fifthdimensiontest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

//    @Autowired
//    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;
    @Override
    public User getUserByName(String username) {
        if(username.equals("test")){
            User user = new User("test","123456",List.of(new Role(RoleType.USER)));
            return user;
        }
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new RuntimeException("用户不存在");
        }

        return user;
    }
}
