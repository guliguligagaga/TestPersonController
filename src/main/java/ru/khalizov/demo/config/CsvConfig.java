package ru.khalizov.demo.config;

import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import ru.khalizov.demo.model.Person;
import ru.khalizov.demo.service.FileService.FileProvider;
import ru.khalizov.demo.service.csvWriter.CsvWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;

@Configuration
public class CsvConfig {

    @Autowired
    private FileProvider fileProvider;

    private final String pathToNewCsvFile;

    public CsvConfig(@Value("${csv.path.person}") String pathToNewCsvFile) {
        this.pathToNewCsvFile = pathToNewCsvFile;
    }

    @Bean
    @SneakyThrows
    @Scope("prototype")
    protected Writer getNewFileWriter() {
        File file = fileProvider.getFile(pathToNewCsvFile);
        return new FileWriter(file, true);
    }

    @Bean
    public CsvWriter<Person> getCsvWriter() {
        return new CsvWriter<Person>() {
            @Override
            public Writer getNewCsvWriter() {
                return getNewFileWriter();
            }

            @Override
            public StatefulBeanToCsv<Person> getStatefulBeanFromWriter(Writer writer) {
                return getCsvBean(writer);
            }
        };
    }

    @Bean
    @Scope("prototype")
    protected StatefulBeanToCsv<Person> getCsvBean(Writer writer) {
        return new StatefulBeanToCsvBuilder<Person>(writer)
                .withSeparator(';')
                .build();
    }
}
