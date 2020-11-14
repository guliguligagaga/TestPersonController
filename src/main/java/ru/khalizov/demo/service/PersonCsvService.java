package ru.khalizov.demo.service;


import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.khalizov.demo.model.Person;
import ru.khalizov.demo.service.csvWriter.CsvWriter;

import java.io.*;

@Service
public class PersonCsvService {

    @Autowired
    private CsvWriter<Person> csvWriter;

    public boolean writePersonToCsv(Person person) {
        return csvWriter.writeFile(person);
    }


}
