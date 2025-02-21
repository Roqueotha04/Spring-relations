package com.relations.Services;

import com.relations.Repositories.ClubRepository;
import com.relations.Repositories.CoachRepository;
import com.relations.Repositories.CompetitionRepository;
import com.relations.Repositories.PlayerRepository;
import com.relations.entities.Club;
import com.relations.entities.Coach;
import com.relations.entities.Competition;
import com.relations.entities.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClubServiceImp implements ClubService{

    @Autowired
    private CoachRepository coachRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private CompetitionRepository competitionRepository;

    @Autowired
    ClubRepository clubRepository;

    @Override
    public List<Club> findAll() {
        return (List<Club>) clubRepository.findAll();
    }

    @Override
    public Optional<Club> findById(Long id) {
        return clubRepository.findById(id);
    }

 /*   public Club createClub(Club club) {
        // Buscar el entrenador por su ID
        Coach coach = coachRepository.findById(club.getCoach().getId())
                .orElseThrow(() -> new RuntimeException("Coach not found"));

        // Buscar los jugadores por sus IDs
            List<Player> players = (List<Player>) playerRepository
                        .findAllById(club.getPlayers().stream()
                        .map(Player::getId)
                        .collect(Collectors.toList()));

        // Buscar las competiciones por sus IDs
             List<Competition> competitions = (List<Competition>) competitionRepository
                        .findAllById(club.getCompetitionsList().stream()
                        .map(Competition::getId)
                        .collect(Collectors.toList()));

        // Establecer las relaciones de las entidades en el club
        club.setCoach(coach);
        club.setPlayers(players);
        club.setCompetitionsList(competitions);

        // Guardar el club en la base de datos
        return clubRepository.save(club);
    } */

    @Override
    public Club save(Club club) {
        System.out.println(club.toString());
        return clubRepository.save(club);
    }

    @Override
    public void delete(Long id) {
        clubRepository.deleteById(id);
    }

    @Override
    public List<Club> findByName(String name) {
        return null;
    }

    @Override
    public Club update(Long id, Club club1) {
        Optional<Club> existingClub= findById(id);
        existingClub.get().getId();
       // existingClub.ifPresent(c -> club1.setId(c.getId()));
        return save(club1);
    }
}
