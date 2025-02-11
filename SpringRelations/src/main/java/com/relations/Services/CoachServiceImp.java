package com.relations.Services;

import com.relations.Repositories.CoachRepository;
import com.relations.entities.Coach;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class CoachServiceImp implements CoachService{
    @Autowired
    private CoachRepository coachRepository;


    @Override
    public List<Coach> findAll() {
        return (List<Coach>) this.coachRepository.findAll();
    }

    @Override
    public Optional<Coach> findById(Long id) {
        Optional <Coach>coach =this.coachRepository.findById(id);
        return coach;
    }

    @Override
    public Coach save(Coach coach) {
        System.out.println(coach.toString());
        return this.coachRepository.save(coach);
    }

    @Override
    public void delete(Long id) {
        this.coachRepository.deleteById(id);
    }

    @Override
    public List<Coach> findByName(String name) {
        return coachRepository.findByName(name);
    }

    @Override
    public Coach update(Long id, Coach coach) {
        Optional<Coach>existingCoach= findById(id);
        if (existingCoach.isPresent()){
            coach.setId(id);
            return save(coach);
        }
        return null;
    }

}
