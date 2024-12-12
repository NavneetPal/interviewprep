package com.navan.interviewprep.external.client;


import com.navan.interviewprep.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name="microserviceapp/ms")
public interface UserMicroService {
    @GetMapping("/getUserData")
    ResponseEntity<List<User>> fetchEmployeeData();
}
