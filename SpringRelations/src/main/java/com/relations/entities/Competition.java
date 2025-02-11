package com.relations.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Competition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /// JPA crea la clave primaria por mi
    private Long id;
    private String name;

    @Column(name="cuantity_price", columnDefinition = "VARCHAR(20)",nullable = false)
    private Integer cuantityPrice;
    /// indico que es de tipo DATE EN SQL
    @Column (name ="starting_date", columnDefinition = "DATE",unique = true)
    private LocalDate startingDate;
    @Column(name="ending_date")
    private LocalDate endingDate;

    @ManyToMany(mappedBy = "competitionsList")
    private List<Club> clubList;
}
