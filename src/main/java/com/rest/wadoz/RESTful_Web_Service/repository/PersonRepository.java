package com.rest.wadoz.RESTful_Web_Service.repository;

import com.rest.wadoz.RESTful_Web_Service.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
