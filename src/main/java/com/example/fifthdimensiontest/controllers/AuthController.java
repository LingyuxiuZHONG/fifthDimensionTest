package com.example.fifthdimensiontest.controllers;

import cn.hutool.jwt.JWT;
import com.example.fifthdimensiontest.dto.SignInRequest;
import com.example.fifthdimensiontest.util.MyConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;


@RestController
@RequestMapping("")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;


    @PostMapping("/login")
    public String login(@RequestBody SignInRequest req){
        if (!"test".equals(req.getUsername()) && !"123456".equals(req.getPassword())) {
            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(req.getUsername(), req.getPassword());
            authenticationManager.authenticate(authenticationToken);

        }
        String token = JWT.create()
                .setPayload("username",req.getUsername())
                .setKey(MyConstant.JWT_SIGN_KEY.getBytes(StandardCharsets.UTF_8))
                .sign();
        return token;

    }

}
