package com.navan.interviewprep.service;


import com.navan.interviewprep.entity.Employee;
import com.navan.interviewprep.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public ResponseEntity<Employee> storeEmployee(Employee emp){
        Employee saveEmp = employeeRepository.save(emp);
        return ResponseEntity.ok(saveEmp);
    }

    public ResponseEntity<List<Employee>> fetchTopEmployee(){
        List<Employee> empList = employeeRepository.findTop3BySalary();
        return ResponseEntity.ok(empList);
    }

    public String greet(String name) {
        return "Hello, " + name + "!";
    }

}
