package com.rest.wadoz.RESTful_Web_Service.service;

import com.rest.wadoz.RESTful_Web_Service.exception.NotFoundPersonException;
import com.rest.wadoz.RESTful_Web_Service.model.Person;
import com.rest.wadoz.RESTful_Web_Service.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Page<Person> findAll(Pageable pageable) {
        return personRepository.findAll(pageable);
    }

    @Override
    public Optional<Person> getById(Long id) {
        if (personRepository.existsById(id)) {
            return personRepository.findById(id);
        } else throw new NotFoundPersonException();

    }

    @Override
    public void create(Person person) {
        personRepository.save(person);
    }

    @Override
    public void delete(Long id) {
        if (personRepository.findById(id).isPresent()) {
            personRepository.deleteById(id);
        } else throw new NotFoundPersonException();
    }

    @Override
    public void update(Long id, Person person) {
        if (personRepository.findById(id).isPresent()){
            personRepository.save(person);
        } else throw new NotFoundPersonException();
    }
}
