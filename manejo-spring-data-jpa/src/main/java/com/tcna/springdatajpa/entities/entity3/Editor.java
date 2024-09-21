package com.tcna.springdatajpa.entities.entity3;

import java.util.*;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Esta es la entidad propietaria
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Editor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    /*
    le indicamos quien es el dueño de la relacion
    Cascada tipo ALL para que cualquier cambio que se haga en editor, afecte a las hijas
    fetch eager indica que los datos de la entidad relacionada se cargaran automaticamente
    */
    @OneToMany(mappedBy = "editor", cascade = CascadeType.ALL, fetch = FetchType.EAGER) 
    private List<Revista> revistas = new ArrayList<>();
}
