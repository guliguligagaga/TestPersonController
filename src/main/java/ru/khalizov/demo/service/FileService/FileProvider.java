package ru.khalizov.demo.service.FileService;

import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;

@Service
public class FileProvider {

    @SneakyThrows
    public File getFile (String path) {
        File file = ResourceUtils.getFile(
                path);
        if (!file.exists()) {
            file.createNewFile();
        }
        return file;
    }
}
