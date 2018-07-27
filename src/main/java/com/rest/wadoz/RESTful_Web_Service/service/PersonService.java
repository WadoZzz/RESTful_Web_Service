package com.rest.wadoz.RESTful_Web_Service.service;

import com.rest.wadoz.RESTful_Web_Service.model.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface PersonService {

    Page<Person> findAll(Pageable pageable);

    Optional<Person> getById(Long id);

    void create(Person person);

    void delete(Long id);

    void update(Long id, Person person);

}
