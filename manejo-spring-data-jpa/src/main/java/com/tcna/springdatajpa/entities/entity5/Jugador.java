package com.tcna.springdatajpa.entities.entity5;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Jugador {
    @Id
    @GeneratedValue
    private long id;
    private String nombre;
    private int numeroCamiseta;

    @ManyToOne
    @JoinColumn(name = "equipo")
    private Equipo equipo;
}
