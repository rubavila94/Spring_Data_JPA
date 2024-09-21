package com.tcna.springdatajpa.entities.entity3;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

//Esta es la entidad inversa. Es la que mapea la entidad propietaria
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Revista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @ManyToOne
    @JoinColumn(name="editor_id")
    private Editor editor;
}
