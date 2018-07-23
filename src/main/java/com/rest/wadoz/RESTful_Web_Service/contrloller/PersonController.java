package com.rest.wadoz.RESTful_Web_Service.contrloller;

import com.rest.wadoz.RESTful_Web_Service.exception.NotFoundPersonException;
import com.rest.wadoz.RESTful_Web_Service.model.Person;
import com.rest.wadoz.RESTful_Web_Service.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    /**
     *  --> Show all Person in database
     */

    @RequestMapping(value = "/all", method = RequestMethod.GET )
    @ResponseBody
    public Iterable<Person> getAllPerson() {
        return personRepository.findAll();
    }
    /**
     *  --> Create a new Person and save it in the database.
     */

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public String addOnePerson(String firstName, String lastName, String phoneNumber) {
        String personId = "";
        try {
            Person person = new Person(firstName, lastName, phoneNumber);
            personRepository.save(person);
            personId = String.valueOf(person.getId());
        } catch (NotFoundPersonException ex) {
            return "Error creating the Person " + ex.toString();
        }
        return "Person successfully created with id = " + personId;
    }

    /**
     *  --> Delete the Person from database.
     */

    @RequestMapping(value = "/del", method = RequestMethod.DELETE)
    @ResponseBody
    public String deletePerson(Long id) {
        try {
            Person person = new Person(id);
            personRepository.delete(person);
        } catch (NotFoundPersonException ex) {
            return "Error deleting the Person " + ex.toString();
        }
        return "Person successfully deleted !";
    }

    /**
     *  --> Find the Person in the database by First Name.
     */

    @RequestMapping(value = "/find", method = RequestMethod.GET)
    @ResponseBody
    public String getFirstName(String firstName) {
        String userId = "";
        try {
            Person person = personRepository.findByFirstName(firstName);
            userId = String.valueOf(person.getId());
        } catch (NotFoundPersonException ex) {
            return "Person not found";
        }
        return "The person id is: " + userId;
    }

    /**
     * Update the First Name, Last Name and Phone Number for the person in the
     * database having the passed id.
     */

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @ResponseBody
    public String updatePerson(long id, String firstName, String lastName, String phoneNumber) {
        try {
            Person person = personRepository.getPersonById(id);
            person.setFirstName(firstName);
            person.setLastName(lastName);
            person.setPhoneNumber(phoneNumber);
            personRepository.save(person);
        } catch (NotFoundPersonException ex) {
            return "Error updating the person: " + ex.toString();
        }
        return "Person successfully updated!";
    }
}
