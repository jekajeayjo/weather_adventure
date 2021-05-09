package md.weatherAdventure.service.impl;


import md.weatherAdventure.service.FileService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.stream.Collectors;

@Service
public class FileServiceImpl implements FileService {



    @Override
    public String readFile( String pathFile) {

        String st = "";
        try {
            File file = new File(pathFile);
            BufferedReader buffer = new BufferedReader(new FileReader(file));
            st = buffer.lines().collect(Collectors.joining());
        } catch (Exception e) {

        }

        return st;


    }
}
