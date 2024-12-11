package com.navan.interviewprep.service;

import com.navan.interviewprep.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Service
public class UserService {

    @Autowired
    private RestTemplate restTemplate;

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

}
