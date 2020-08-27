package net.javaguides.springmvc.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.javaguides.springmvc.entity.Employee;
import net.javaguides.springmvc.exception.ResourceNotFoundException;
import net.javaguides.springmvc.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    private static final Logger LOG = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/list")
    public String listEmployees(Model theModel) {
        List < Employee > theEmployees = employeeService.getEmployees();
        theModel.addAttribute("employees", theEmployees);
        return "list-employees";
    }

    @GetMapping("/showForm")
    public String showFormForAdd(Model theModel) {
        LOG.debug("inside show employee-form handler method");
        Employee theEmployee = new Employee();
        theModel.addAttribute("employee", theEmployee);
        return "employee-form";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee theEmployee) {
        employeeService.saveEmployee(theEmployee);
        return "redirect:/employee/list";
    }

    @GetMapping("/updateForm")
    public String showFormForUpdate(@RequestParam("employeeId") int theId,
        Model theModel) throws ResourceNotFoundException {
        Employee theEmployee = employeeService.getEmployee(theId);
        theModel.addAttribute("employee", theEmployee);
        return "employee-form";
    }

    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("employeeId") int theId) throws ResourceNotFoundException {
        employeeService.deleteEmployee(theId);
        return "redirect:/employee/list";
    }
}