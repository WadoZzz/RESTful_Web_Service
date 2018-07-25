package com.rest.wadoz.RESTful_Web_Service.service;

import com.rest.wadoz.RESTful_Web_Service.model.Person;

import java.util.List;
import java.util.Optional;

public interface PersonService {

    List<Person> findAllPerson();

    Optional getPersonById(Long id);

    Person createPerson(Person person);

    Person deletePerson(Long id);

    Person updatePerson(Person person, Long id);

}
