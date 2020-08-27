package net.javaguides.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.javaguides.springmvc.entity.Employee;
import net.javaguides.springmvc.exception.ResourceNotFoundException;
import net.javaguides.springmvc.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    @Transactional
    public List < Employee > getEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    @Transactional
    public void saveEmployee(Employee theEmployee) {
        employeeRepository.save(theEmployee);
    }

    @Override
    @Transactional
    public Employee getEmployee(int id) throws ResourceNotFoundException {
        return employeeRepository.findById(id).orElseThrow(
            () -> new ResourceNotFoundException(id));
    }

    @Override
    @Transactional
    public void deleteEmployee(int theId) {
        employeeRepository.deleteById(theId);
    }
}