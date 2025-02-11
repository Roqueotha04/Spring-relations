package com.relations.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /// JPA crea la clave primaria por mi
    private Long id;
    private String name;

    /// nomenclatura sql
    @Column(name= "last_name")
    private String lastName;

    private Integer age;
    private String nationality;
    private String position;

    @ManyToOne (targetEntity = Club.class)
    private Club club;
}
