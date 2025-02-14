package com.relations.Repositories;

import com.relations.entities.Coach;
import com.relations.entities.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends CrudRepository<Player, Long> {
    List<Player> findByName (String name);
}
