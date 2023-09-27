package com.ista.codingChallenge.util;

import com.ista.codingChallenge.model.University;
import com.ista.codingChallenge.repositories.UniversityRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DatabasePopulator {

    @Autowired
    private UniversityRepository repository;
    @Autowired
    private CSVReader csvReader;


    @PostConstruct
    public void loadCSVData() {
        List<List<String>> lines = csvReader.readCSVFile("src/main/resources/data.csv");
        for (List<String> line : lines) {
            University university = new University();
            university.setId(Long.parseLong(line.get(0)));
            university.setSource(line.get(1));
            university.setUniversityName(line.get(2));
            university.setCountry(line.get(3));
            repository.save(university);
        }
    }

}
