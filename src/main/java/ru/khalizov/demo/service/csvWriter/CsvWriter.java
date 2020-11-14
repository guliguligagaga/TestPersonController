package ru.khalizov.demo.service.csvWriter;

import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.Writer;

@Service
public abstract class CsvWriter<T> {

    @SneakyThrows
    public boolean writeFile (T object) {
        Writer writer = getNewCsvWriter();
        StatefulBeanToCsv<T> sbc = getStatefulBeanFromWriter(writer);
        sbc.write(object);
        writer.close();
        return sbc.getCapturedExceptions().isEmpty();
    }

    public abstract Writer getNewCsvWriter();

    public abstract StatefulBeanToCsv<T> getStatefulBeanFromWriter(Writer writer);
}
