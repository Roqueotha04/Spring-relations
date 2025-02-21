package com.relations.controllers;

import com.relations.Services.ClubService;
import com.relations.Services.ClubServiceImp;
import com.relations.entities.Club;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/club")
public class ClubController {

    @Autowired
    ClubServiceImp clubService;

    @GetMapping
    public List<Club> getAllClubs (){
        return this.clubService.findAll();
    }

    /* un caso donde se podria utilizar un orElseThrow con manejo de excepciones.
    @GetMapping("/{id}")
    public ResponseEntity<?> getClubById(@PathVariable Long id) {
    Club club = clubService.findById(id)
            .orElseThrow(() -> new ClubNotFoundException("Club no encontrado"));

    return ResponseEntity.ok(club);
    }
     */
    @GetMapping ("/{id}")
    public ResponseEntity<?> getClubById (@PathVariable Long id){
        Optional<Club> clubOptional=this.clubService.findById(id);
        if(clubOptional.isPresent()){
            return ResponseEntity.ok(clubOptional.get());
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado");
        }
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<?> deleteClub (@PathVariable Long id){
        this.clubService.delete(id);
        return ResponseEntity.ok(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity<?> postClub (@RequestBody Club club){
        this.clubService.save(club);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @PutMapping ("/{id}")
    public ResponseEntity <?> updateClub (@PathVariable Long id, @RequestBody Club club){
        this.clubService.update(id,club);
        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }
}
