package com.rest.wadoz.RESTful_Web_Service.service;

import com.rest.wadoz.RESTful_Web_Service.model.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PersonService {

    Page<Person> findAll(Pageable pageable);

    Person getById(Long id);

    void create(Person person);

    void delete(Long id);

    void update(Long id, Person person);

}
