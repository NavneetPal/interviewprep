package com.navan.interviewprep.controller;


import com.navan.interviewprep.entity.Employee;
import com.navan.interviewprep.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/create")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
        return employeeService.storeEmployee(employee);
    }

    @GetMapping("/topEmp")
    public ResponseEntity<List<Employee>> getTop3Employee(){
        return employeeService.fetchTopEmployee();
    }
}
