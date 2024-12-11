package com.navan.interviewprep.controller;


import com.navan.interviewprep.entity.Employee;
import com.navan.interviewprep.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/employee")
@RequiredArgsConstructor
@RefreshScope
@Slf4j
public class EmployeeController {

    private final EmployeeService employeeService;

    @Value("${company.name}")
    private String company;

    @Value("${company.designation}")
    private String designation;

    @PostMapping("/create")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
        return employeeService.storeEmployee(employee);
    }

    @GetMapping("/topEmp")
    public ResponseEntity<List<Employee>> getTop3Employee(){
        return employeeService.fetchTopEmployee();
    }

    @GetMapping("/greet")
    public ResponseEntity<String> greet(
            @RequestParam(value="name", defaultValue="") String name
    ){
        String greeting = employeeService.greet(name);
        return ResponseEntity.ok(greeting);
    }

    @GetMapping(path="/company")
    public ResponseEntity<String> getCompanyName(){
        log.info("Fetching the company name");
        String res = "Employee worked in a "+company+" as a "+designation +"role";
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    
}
