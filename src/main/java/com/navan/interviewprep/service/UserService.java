package com.navan.interviewprep.service;

import com.navan.interviewprep.external.client.UserMicroService;
import com.navan.interviewprep.model.User;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


@Service
@Slf4j
public class UserService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserMicroService microService;

    @CircuitBreaker(name="userservice",fallbackMethod="getDefaultUserDetails")
    public ResponseEntity<List<User>> getUserDetails() {
        String url = "http://MICROSERVICEAPP/ms/getUserData";
        ResponseEntity<List<User>> userList = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<User>>() {}
        );

        return userList;
    }


    public ResponseEntity<List<User>> getUserDetailsThroughFeignClient() {
        ResponseEntity<List<User>> userList = microService.fetchEmployeeData();
        log.info("FeignClient fetched the user data successfully");
        return userList;
    }

    public ResponseEntity<List<User>> getDefaultUserDetails(Exception ex){
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.OK);
    }


}
