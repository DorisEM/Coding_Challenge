package com.ista.codingChallenge.controllers;

import com.ista.codingChallenge.model.University;
import com.ista.codingChallenge.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/universities")
@CrossOrigin(origins = "http://localhost:5173")
public class UniversityController {

    @Autowired
    private UniversityService universityService;

    @GetMapping
    public List<University> displayAllData() {
        return universityService.findAllData();
    }

    @GetMapping("/names")
    public List<String> getAllUniversityNames() {
        return universityService.findAllUniversityNames();
    }

    @GetMapping("/countries")
    public List<String> getAllCountries() {
        return universityService.findAllCountries();
    }

    @GetMapping("/sorted-by-country")
    public List<University> getAllSortedByCountry() {
        return universityService.findAllSortedByCountry();
    }

    @GetMapping("/sorted-by-id")
    public List<University> getAllSortedById() {
        return universityService.findAllSortedById();
    }
}
