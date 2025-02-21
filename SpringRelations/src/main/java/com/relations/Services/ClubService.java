package com.relations.Services;

import com.relations.entities.Club;

import java.util.List;
import java.util.Optional;

public interface ClubService {
    List<Club> findAll();
    Optional<Club> findById(Long id);
    Club save (Club club);
    void delete (Long id);
    List<Club>findByName(String name);
    Club update(Long id, Club club);
}
