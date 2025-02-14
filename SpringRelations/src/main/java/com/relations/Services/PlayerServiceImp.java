package com.relations.Services;

import com.relations.Repositories.PlayerRepository;
import com.relations.entities.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.management.PlatformLoggingMXBean;
import java.util.List;
import java.util.Optional;

@Service
public class PlayerServiceImp implements PlayerService{
    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public List<Player> findAll() {
        return (List<Player>) playerRepository.findAll();
    }

    @Override
    public Optional<Player> findById(Long id) {
        return playerRepository.findById(id);
    }

    @Override
    public Player save(Player player) {
        return playerRepository.save(player);
    }

    @Override
    public void delete(Long id) {
        playerRepository.deleteById(id);
    }

    @Override
    public List<Player> findByName(String name) {
        return playerRepository.findByName(name);
    }

    @Override
    public Player update(Long id, Player player1) {
        Optional<Player> existingPlayer= findById(id);
        existingPlayer.ifPresent(p -> player1.setId(p.getId()));
        return save(player1);
    }
}
