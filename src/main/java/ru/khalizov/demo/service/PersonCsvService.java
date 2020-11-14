package ru.khalizov.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.khalizov.demo.model.Person;
import ru.khalizov.demo.service.csvWriter.CsvWriter;


@Service
public class PersonCsvService {

    @Autowired
    private CsvWriter<Person> csvWriter;

    public boolean writePersonToCsv(Person person) {
        return csvWriter.writeFile(person);
    }


}
