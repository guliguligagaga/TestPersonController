package ru.khalizov.demo.service;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.khalizov.demo.model.Person;
import ru.khalizov.demo.repository.PersonRepository;

import java.io.IOException;


@Service
public class PersonService {

    PersonRepository personRepository;

    @Autowired
    private PersonCsvService personCsvService;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person saveToDb(Person person) {
        personRepository.save(person);
        return person;
    }

    public boolean saveToCsv(Person person) {
       return personCsvService.writePersonToCsv(person);
    }

}
