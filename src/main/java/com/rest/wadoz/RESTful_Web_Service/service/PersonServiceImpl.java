package com.rest.wadoz.RESTful_Web_Service.service;

import com.rest.wadoz.RESTful_Web_Service.model.Person;
import com.rest.wadoz.RESTful_Web_Service.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Iterable<Person> findAllPerson() {
       return personRepository.findAll();
    }

    @Override
    public Optional<Person> getPersonById(Long id) {
       return personRepository.findById(id);
    }

    @Override
    public Person createPerson(Person person) {
       return personRepository.save(person);
    }

    @Override
    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }

    @Override
    public void updatePerson(Person person, Long id) {
       person.setId(id);
       personRepository.save(person);
    }
}
