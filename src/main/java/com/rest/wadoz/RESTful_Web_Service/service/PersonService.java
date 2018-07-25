package com.rest.wadoz.RESTful_Web_Service.service;

import com.rest.wadoz.RESTful_Web_Service.model.Person;

import java.util.Optional;

public interface PersonService {

    Iterable<Person> findAllPerson();

    Optional<Person> getPersonById(Long id);

    Person createPerson(Person person);

    void deletePerson(Long id);

    void updatePerson(Person person, Long id);

}
