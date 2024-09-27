package com.tcna.springdatajpa.entities.entity6;

import java.util.*;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Aerolinea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @OneToMany(mappedBy = "aerolinea", cascade = CascadeType.REMOVE)
    //inicializamos el array para que este lista para almacenar datos
    private List<Vuelo> vuelos = new ArrayList<>();
}
