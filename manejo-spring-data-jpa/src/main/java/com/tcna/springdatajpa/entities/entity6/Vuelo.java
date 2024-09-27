package com.tcna.springdatajpa.entities.entity6;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Vuelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numeroVuelo;
    private String destino;

    @ManyToOne
    @JoinColumn(name="aerolinea_id")
    private Aerolinea aerolinea;
}
