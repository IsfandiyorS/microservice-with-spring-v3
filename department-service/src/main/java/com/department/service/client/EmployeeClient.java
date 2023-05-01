package com.department.service.client;

import com.department.service.model.Employee;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.List;

@HttpExchange
public interface EmployeeClient {

    @GetExchange("/api/v1/employee/department/{id}")
    List<Employee> findByDepartmentId(@PathVariable("id") Long departmentId);

}
