package com.employee.service.controller;

import com.employee.service.model.Employee;
import com.employee.service.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    @PostMapping()
    public Employee addEmployee(@RequestBody Employee department){
        log.info("Employee add: {}", department);
        return employeeRepository.addDepartment(department);
    }

    @GetMapping()
    public List<Employee> findAllEmployee() {
        log.info("Employee findAll");
        return employeeRepository.findAllDepartment();
    }

    @GetMapping("/{id}")
    public Employee findById(@PathVariable("id") Long id){
        log.info("Employee findById: {}", id);
        return employeeRepository.findById(id);
    }

    @GetMapping("/department/{id}")
    public List<Employee> findByDepartmentId(@PathVariable("id") Long departmentId){
        log.info("Department findById: {}", departmentId);
        return employeeRepository.findByDepartmentId(departmentId);
    }
}
