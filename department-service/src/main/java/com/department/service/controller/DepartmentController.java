package com.department.service.controller;

import com.department.service.client.EmployeeClient;
import com.department.service.model.Department;
import com.department.service.model.Employee;
import com.department.service.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/department")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentRepository departmentRepository;
    private final EmployeeClient employeeClient;

    @PostMapping()
    public Department addDepartment(@RequestBody Department department) {
        log.info("Department add: {}", department);
        return departmentRepository.addDepartment(department);
    }

    @GetMapping()
    public List<Department> findAllDepartment() {
        log.info("Department findAll");
        List<Department> departments = departmentRepository.findAllDepartment();

        departments
                .forEach(
                        department -> department
                                .setEmployees(employeeClient.findByDepartmentId(department.getId())
                ));

        return departments;
    }

    @GetMapping("/{id}")
    public Department findById(@PathVariable("id") Long id) {
        log.info("Department findById: {}", id);
        Department department = departmentRepository.findById(id);
        List<Employee> employeeListByDepartmentId = employeeClient.findByDepartmentId(department.getId());
        department.setEmployees(employeeListByDepartmentId);
        return department;
    }

}
