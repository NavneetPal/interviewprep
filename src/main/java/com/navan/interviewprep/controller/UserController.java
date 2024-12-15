package com.navan.interviewprep.controller;


import com.navan.interviewprep.model.User;
import com.navan.interviewprep.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    @GetMapping("/data/v1")
    public ResponseEntity<List<User>> getUserDataV1(){
        log.info("Request to fetch User data through RestTemplate");
        return userService.getUserDetails();
    }

    @GetMapping("/data/v2")
    public ResponseEntity<List<User>> getUserDataV2(){
        log.info("Request to fetch User dataThrough Feignclient");
        return userService.getUserDetailsThroughFeignClient() ;
    }
}
