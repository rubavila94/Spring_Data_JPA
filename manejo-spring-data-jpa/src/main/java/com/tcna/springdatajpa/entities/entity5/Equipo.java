package com.tcna.springdatajpa.entities.entity5;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Equipo {
    @Id
    @GeneratedValue
    private long id;
    private String nombre;

    @OneToMany(mappedBy = "equipo", cascade=CascadeType.MERGE, fetch = FetchType.LAZY)
    private List<Jugador> jugadores = new ArrayList<>();
}
