package com.navan.interviewprep.external.client;


import com.navan.interviewprep.exception.CustomException;
import com.navan.interviewprep.model.User;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@CircuitBreaker(name="userservice",fallbackMethod="fallback")
@FeignClient(name="microserviceapp/ms")
public interface UserMicroService {
    @GetMapping("/getUserData")
    ResponseEntity<List<User>> fetchEmployeeData();

    /**
     * Fallback Method
     * @param e
     * @return
     */
    default ResponseEntity<List<User>> fallback(Exception e){
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(new ArrayList<>());
    }
}
