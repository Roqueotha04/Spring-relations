package com.relations.controllers;

import com.relations.Services.CompetitionService;
import com.relations.entities.Competition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api/competition")
public class CompetitionController {

    @Autowired
    CompetitionService competitionService;

    @GetMapping
    public List<Competition> getAllCompetition (){
        return competitionService.findAll();
    }

    @GetMapping("/{id}")
    public Competition getCompetitionByID (@PathVariable Long id){
        return competitionService.findById(id).orElseThrow(()->new RuntimeException("There is no such competition with ID: " + id));
    }

    @PostMapping
    public Competition postCompetition (@RequestBody Competition competition){
        return competitionService.save(competition);
    }

    @DeleteMapping("/{id}")
    public void deleteCompetition (@PathVariable Long id){
        competitionService.delete(id);
    }

    @PutMapping ("/{id}")
    public Competition updateCompetition (@PathVariable Long id, @RequestBody Competition competition){
        return competitionService.update(id, competition);
    }
}
