package com.rest.wadoz.RESTful_Web_Service.repository;


import com.rest.wadoz.RESTful_Web_Service.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface PersonRepository extends CrudRepository<Person, Long> {
    Person findByFirstName(String firstName);

    Person getPersonById(Long id);
}
