package com.relations.Services;

import com.relations.entities.Competition;

import java.util.List;
import java.util.Optional;

public interface CompetitionService {
    List<Competition> findAll();
    Optional<Competition> findById(Long id);
    Competition save (Competition competition);
    void delete (Long id);
    List<Competition>findByName(String name);
    Competition update(Long id, Competition competition);
}
