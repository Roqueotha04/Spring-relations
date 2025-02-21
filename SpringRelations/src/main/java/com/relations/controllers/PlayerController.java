package com.relations.controllers;

import com.relations.Services.PlayerService;
import com.relations.entities.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/player")
@RestController
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @GetMapping
    public List <Player> getAllPlayers(){
        return playerService.findAll();
    }

    @GetMapping("/{id}")
    public Player getPlayerById (@PathVariable Long id){
        return playerService.findById(id).get();
    }

    @PostMapping
    public Player postPlayer(@RequestBody Player player){
        return playerService.save(player);
    }

    @PostMapping ("/all")
    public List<Player> postManyPlayers(@RequestBody List <Player> players){
        return playerService.saveAll(players);
    }

    @PutMapping("/{id}")
    public Player updatePlayer(@PathVariable Long id, @RequestBody Player player){
        return playerService.update(id,player);
    }

    @DeleteMapping("/{id}")
    public void deletePlayer (@PathVariable Long id){
        playerService.delete(id);
    }



}
