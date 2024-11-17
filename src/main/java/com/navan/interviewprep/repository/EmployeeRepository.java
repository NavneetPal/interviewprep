package com.navan.interviewprep.repository;

import com.navan.interviewprep.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    @Query(value = "Select * from employee order by salary desc limit 3",nativeQuery=true)
    List<Employee> findTop3BySalary();
}
