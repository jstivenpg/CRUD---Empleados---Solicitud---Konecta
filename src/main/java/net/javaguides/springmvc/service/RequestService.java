package net.javaguides.springmvc.service;

import java.util.List;

import net.javaguides.springmvc.entity.Request;
import net.javaguides.springmvc.exception.ResourceNotFoundException;

public interface RequestService {

    public List < Request > getRequests();

    public void saveRequest(Request theRequest);

    public Request getRequest(int theId) throws ResourceNotFoundException;

    public void deleteRequest(int theId) throws ResourceNotFoundException;
}