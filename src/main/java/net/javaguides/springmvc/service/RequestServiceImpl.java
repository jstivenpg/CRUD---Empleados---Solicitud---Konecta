package net.javaguides.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.javaguides.springmvc.entity.Request;
import net.javaguides.springmvc.exception.ResourceNotFoundException;
import net.javaguides.springmvc.repository.RequestRepository;

@Service
public class RequestServiceImpl implements RequestService {

    @Autowired
    private RequestRepository requestRepository;

    @Override
    @Transactional
    public List < Request > getRequests() {
        return requestRepository.findAll();
    }

    @Override
    @Transactional
    public void saveRequest(Request theRequest) {
        requestRepository.save(theRequest);
    }

    @Override
    @Transactional
    public Request getRequest(int id) throws ResourceNotFoundException {
        return requestRepository.findById(id).orElseThrow(
            () -> new ResourceNotFoundException(id));
    }

    @Override
    @Transactional
    public void deleteRequest(int theId) {
        requestRepository.deleteById(theId);
    }
}