package com.ista.codingChallenge.util;

import com.ista.codingChallenge.model.University;
import com.ista.codingChallenge.repositories.UniversityRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DatabasePopulator {


    private UniversityRepository repository;
    private CSVReader csvReader;

    public DatabasePopulator(UniversityRepository repository, CSVReader csvReader) {
        this.repository = repository;
        this.csvReader = csvReader;
    }

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
