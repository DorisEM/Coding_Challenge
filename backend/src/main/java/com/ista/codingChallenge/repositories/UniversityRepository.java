package com.ista.codingChallenge.repositories;

import com.ista.codingChallenge.model.University;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UniversityRepository extends JpaRepository<University, Long> {
    @Query("SELECT u.universityName FROM University u")
    List<String> findAllUniversityNames();

    @Query("SELECT u.country FROM University u")
    List<String> findAllCountry();

    @Query("SELECT u.source FROM University u")
    List<String> findAllSource();

    Optional<University> findById(Long id);

    List<University> findAllByOrderByCountryAsc();

    List<University> findAllByOrderByIdAsc();

    List<University> findAll();


}
