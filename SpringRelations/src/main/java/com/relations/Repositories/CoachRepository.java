package com.relations.Repositories;

import com.relations.entities.Coach;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoachRepository extends CrudRepository<Coach,Long> {
    List<Coach> findByName (String name);
}
