package net.javaguides.springmvc.service;

import java.util.List;

import net.javaguides.springmvc.entity.Employee;
import net.javaguides.springmvc.exception.ResourceNotFoundException;

public interface EmployeeService {

    public List < Employee > getEmployees();

    public void saveEmployee(Employee theEmployee);

    public Employee getEmployee(int theId) throws ResourceNotFoundException;

    public void deleteEmployee(int theId) throws ResourceNotFoundException;
}