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
import net.javaguides.springmvc.entity.Request;
import net.javaguides.springmvc.exception.ResourceNotFoundException;
import net.javaguides.springmvc.service.EmployeeService;
import net.javaguides.springmvc.service.RequestService;
import sun.print.resources.serviceui;

@Controller
@RequestMapping("/request")
public class RequestController {

    private static final Logger LOG = LoggerFactory.getLogger(RequestController.class);

    @Autowired
    private RequestService requestService;
    private EmployeeService employeeService;

    @GetMapping("/list")
    public String listRequests(Model theModel) {
        List < Request > theRequests = requestService.getRequests();
        theModel.addAttribute("requests", theRequests);
        return "list-requests";
    }

    @GetMapping("/showForm")
    public String showFormForAdd(Model theModel) {
        LOG.debug("inside show request-form handler method");
        Request theRequest = new Request();
       // Employee theEmployee = new Employee();
       // theEmployee.setId(1);
      //  theModel.addAttribute("employee", theEmployee);
        theModel.addAttribute("request", theRequest);
        return "request-form";
    }

    @PostMapping("/saveRequest")
    public String saveRequest(@ModelAttribute("request") Request theRequest) {
    	requestService.saveRequest(theRequest);
        return "redirect:/request/list";
    }
    

    @GetMapping("/updateForm")
    public String showFormForUpdate(@RequestParam("requestId") int theId,
        Model theModel) throws ResourceNotFoundException {
        Request theRequest = requestService.getRequest(theId);
        theModel.addAttribute("request", theRequest);
        return "request-form";
    }

    @GetMapping("/delete")
    public String deleteRequest(@RequestParam("requestId") int theId) throws ResourceNotFoundException {
        requestService.deleteRequest(theId);
        return "redirect:/request/list";
    }
}