package com.relations.controllers;

import com.relations.Services.CoachServiceImp;
import com.relations.entities.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api")
public class CoachController {
    @Autowired
    CoachServiceImp coachServiceImp;

    @GetMapping ("/coach")
    public List<Coach> getAllCoachs (){
        return this.coachServiceImp.findAll();
    }

    @PostMapping ("/coach")
    public Coach postCoach (@RequestBody Coach coach){
        String name= coach.getName();
        return this.coachServiceImp.save(coach);
    }

    @DeleteMapping ("/coach/{id}")
    public void deleteCoach (@PathVariable Long id){
        this.coachServiceImp.delete(id);
    }

    @GetMapping ("/coach/{id}")
    public Coach getCoach(@PathVariable Long id){
        return this.coachServiceImp.findById(id).get();
    }

    @GetMapping ("/coach/search")
    public List <Coach> getCoachByName (@RequestParam("name") String name){
        return coachServiceImp.findByName(name);
    }

    @PutMapping ("/coach/{id}")
    public Coach updateCoach (@PathVariable Long id, @RequestParam Coach coach){
        return coachServiceImp.update(id,coach);
    }
}
