package com.relations.Services;

import com.relations.entities.Coach;

import java.util.List;
import java.util.Optional;

public interface CoachService {
     List<Coach> findAll();
     Optional<Coach> findById(Long id);
     Coach save (Coach coach);
     void delete (Long id);
     List<Coach>findByName(String name);
     Coach update(Long id, Coach coach);
}
