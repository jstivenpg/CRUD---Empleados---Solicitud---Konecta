package net.javaguides.springmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springmvc.entity.Request;

@Repository("requestRepository")
public interface RequestRepository extends JpaRepository<Request, Integer> {

}