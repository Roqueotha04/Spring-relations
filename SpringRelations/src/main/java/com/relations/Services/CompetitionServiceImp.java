package com.relations.Services;

import com.relations.Repositories.CompetitionRepository;
import com.relations.entities.Competition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompetitionServiceImp implements CompetitionService{

    @Autowired
    private CompetitionRepository competitionRepository;

    @Override
    public List<Competition> findAll() {
        return (List<Competition>) this.competitionRepository.findAll();
    }

    @Override
    public Optional<Competition> findById(Long id) {
        return competitionRepository.findById(id);
    }

    @Override
    public Competition save(Competition competition) {
        return competitionRepository.save(competition);
    }

    @Override
    public void delete(Long id) {
        competitionRepository.deleteById(id);
    }

    @Override
    public List<Competition> findByName(String name) {
        return competitionRepository.findByName(name);
    }

    @Override
    public Competition update(Long id, Competition competition1) {
        Optional<Competition> existingCompetition = competitionRepository.findById(id);
        System.out.println(competition1.getId());
       /// existingCompetition.ifPresent(c -> System.out.println(c.getId()));
        return save (competition1);
    }
}
