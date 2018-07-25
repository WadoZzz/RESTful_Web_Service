package com.rest.wadoz.RESTful_Web_Service.contrloller;

import com.rest.wadoz.RESTful_Web_Service.exception.NotFoundPersonException;
import com.rest.wadoz.RESTful_Web_Service.model.Person;
import com.rest.wadoz.RESTful_Web_Service.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    /**
     * --> Show all Person in database
     */

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<Person>> findAll() {
        List<Person> personList = (List<Person>) personRepository.findAll();
        return ResponseEntity.ok(personList);
    }

    /**
     * --> Show a Person in database by Id
     */
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Optional> getPersonById(@PathVariable Long id) {
        try {
            Optional<Person> person = personRepository.findById(id);
            return ResponseEntity.ok(person);
        } catch (NotFoundPersonException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    /**
     * --> Create a new Person and save it in the database.
     */

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Person> createPerson(Person person) {
        personRepository.save(person);
        HttpHeaders respHeader = new HttpHeaders();
        return new ResponseEntity<>(person, respHeader, HttpStatus.CREATED);
    }

    /**
     * --> Delete the Person from database.
     */

    @RequestMapping(value = "/del/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<Person> deletePerson(@PathVariable Long id) {
        try {
            personRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (NotFoundPersonException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Update the First Name, Last Name and Phone Number for the person in the
     * database having the passed id.
     */

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<Person> updatePerson(Person person, @PathVariable Long id) {
        try {
            person.setId(id);
            personRepository.save(person);
            HttpHeaders respHeader = new HttpHeaders();
            return new ResponseEntity<>(person, respHeader, HttpStatus.CREATED);
        } catch (NotFoundPersonException ex) {
            return ResponseEntity.notFound().build();
        }
    }

}