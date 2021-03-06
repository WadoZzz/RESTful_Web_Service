package com.rest.wadoz.RESTful_Web_Service.contrloller;

import com.rest.wadoz.RESTful_Web_Service.exception.NotFoundPersonException;
import com.rest.wadoz.RESTful_Web_Service.model.Person;
import com.rest.wadoz.RESTful_Web_Service.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/person")
public class PersonController {

    private IPersonService IPersonService;

    @Autowired
    public PersonController(IPersonService IPersonService) {
        this.IPersonService = IPersonService;
    }
    /**
     * --> Show all Person in database
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Page<Person>> findAll(Pageable pageable) {
        Page<Person> personList = IPersonService.findAll(pageable);
        return ResponseEntity.ok(personList);
    }
    /**
     * --> Show a Person in database by Id
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Optional<Person>> get(@PathVariable Long id) {
        try {
            Optional<Person> person = IPersonService.getById(id);
            return ResponseEntity.ok(person);
        } catch (NotFoundPersonException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
    /**
     * --> Create a new Person and save it in the database.
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Person> create(Person person) {
        IPersonService.create(person);
        return new ResponseEntity<>(person, HttpStatus.CREATED);
    }
    /**
     * --> Delete the Person from database.
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Person> delete(@PathVariable Long id) {
        IPersonService.delete(id);
        return ResponseEntity.ok().build();
    }
    /**
     * Update the First Name, Last Name and Phone Number for the person in the
     * database having the passed id.
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public @ResponseBody
    ResponseEntity<Person> update(@PathVariable Long id,  Person person) {
        IPersonService.update(id, person);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

}