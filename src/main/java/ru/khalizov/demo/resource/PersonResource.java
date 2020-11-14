package ru.khalizov.demo.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import ru.khalizov.demo.model.Person;
import ru.khalizov.demo.service.PersonService;

@RestController
public class PersonResource {

    @Autowired
    private PersonService personService;

    @PostMapping(value = "/person/saveToDb", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Person> savePersonToDb(@RequestBody final Person person) {
        personService.saveToDb(person);
        return ResponseEntity.status(HttpStatus.OK).body(person);
    }

    @PostMapping(value = "/person/saveToCsv", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Person> savePersonToCsv(@RequestBody final Person person) {
        if (personService.saveToCsv(person)) return ResponseEntity.status(HttpStatus.OK).body(person);
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }

}
