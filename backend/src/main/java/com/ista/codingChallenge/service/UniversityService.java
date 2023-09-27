package com.ista.codingChallenge.service;

import com.ista.codingChallenge.model.University;
import com.ista.codingChallenge.repositories.UniversityRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UniversityService {

    private UniversityRepository universityRepository;

    public UniversityService(UniversityRepository universityRepository) {
        this.universityRepository = universityRepository;
    }

    public List<String> findAllUniversityNames() {
        return universityRepository.findAllUniversityNames();
    }

    public List<String> findAllCountries() {
        return universityRepository.findAllCountry();
    }

    public List<String> findAllSources() {
        return universityRepository.findAllSource();
    }

    public List<University> findAllData() { return universityRepository.findAll();}

    public List<University> findAllSortedByCountry() {
        return universityRepository.findAllByOrderByCountryAsc();
    }

    public List<University> findAllSortedById() {
        return universityRepository.findAllByOrderByIdAsc();
    }
}
