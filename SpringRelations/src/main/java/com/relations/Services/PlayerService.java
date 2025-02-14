package com.relations.Services;

import com.relations.entities.Coach;
import com.relations.entities.Player;

import java.util.List;
import java.util.Optional;

public interface PlayerService {
    List<Player> findAll();
    Optional<Player> findById(Long id);
    Player save (Player player);
    void delete (Long id);
    List<Player>findByName(String name);
    Player update(Long id, Player player);
}
