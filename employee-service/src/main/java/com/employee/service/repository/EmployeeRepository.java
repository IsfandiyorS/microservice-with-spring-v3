package com.employee.service.repository;

import com.employee.service.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepository {

    private List<Employee> employeeList = new ArrayList<>();

    public Employee addDepartment(Employee department){
        employeeList.add(department);
        return department;
    }

    public Employee findById(Long id){
        return employeeList.stream()
                .filter(department ->
                        department.id().equals(id))
                .findFirst()
                .orElseThrow();
    }

    public List<Employee> findAllDepartment(){
        return employeeList;
    }


    public List<Employee> findByDepartmentId(Long departmentId){
        return employeeList.stream()
                .filter(employee ->
                        employee.departmentId().equals(departmentId))
                .toList();
    }
}
