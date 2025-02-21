package com.relations.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Club {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /// JPA crea la clave primaria por mi
    private Long id;
    private String name;

    /// target entity funciona como metodo para definir de que clase estoy hablando especificamente.
    /// Cascade type define comportamientos en cascada al insertar o eliminar objetos. Ej remove, si elimino un club se elimina el coach.
    /// Merge, si actualizo info en el club se puede actualizar el coach. Ayudan a la coherencia.
    /// Club es a quien pertenece y maneja la relacion. Guarda la clave foranea del entrenador
    @OneToOne (targetEntity = Coach.class, cascade = CascadeType.REFRESH)
    @JoinColumn(name="id_coach")
    private Coach coach;

    @OneToMany(targetEntity = Player.class, fetch = FetchType.LAZY, mappedBy = "club", cascade = CascadeType.REFRESH)
    private List<Player> players;

    @ManyToMany (targetEntity = Competition.class, fetch= FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinTable(name= "club_x_competition",
            joinColumns = @JoinColumn(name="club_id"),
            inverseJoinColumns = @JoinColumn (name="competition_id"))
    private List <Competition> competitionsList;

}
