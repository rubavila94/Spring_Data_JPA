package com.tcna.springdatajpa.pruebas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.*;
import com.tcna.springdatajpa.entities.entity6.Aerolinea;
import com.tcna.springdatajpa.entities.entity6.Vuelo;
import com.tcna.springdatajpa.repositories.repository6.AerolineaRepository;
import com.tcna.springdatajpa.repositories.repository6.VueloRepository;

//@Component
public class Prueba006 implements CommandLineRunner{

    @Autowired
    private AerolineaRepository aerolineaRepository;

    @Autowired
    private VueloRepository vueloRepository;

    @Override
    public void run(String...args) throws Exception {
        //Creamos una aerolinea con vuelos
        Aerolinea aerolinea = new Aerolinea();
        aerolinea.setNombre("Aerolinea XYZ");

        Vuelo vuelo1 = new Vuelo();
        vuelo1.setNumeroVuelo("XYZ123");
        vuelo1.setDestino("Ciudad A");

        Vuelo vuelo2 = new Vuelo();
        vuelo2.setNumeroVuelo("XYZ456");
        vuelo2.setDestino("Ciudad B");

        aerolinea.getVuelos().add(vuelo1);
        aerolinea.getVuelos().add(vuelo2);

        aerolineaRepository.save(aerolinea);

        //Leer aerolinea desde el repo
        Aerolinea aerolineaDesdeBBDD = aerolineaRepository.findById(aerolinea.getId()).orElse(null);
        System.out.println("Aerolinea: " + aerolineaDesdeBBDD.getNombre());

        //Eliminar aerolinea. Se eliminara la aerolinea y todos los vuelos
        //ya que esta en cascade tipo remove
        aerolineaRepository.delete(aerolineaDesdeBBDD);

        //Comprobamos que aerolinea y vuelos se han eliminado
        List<Vuelo> vuelos = vueloRepository.findAll();
        System.out.println("Numero de vuelos en la BBDD: " + vuelos.size());
    }
}
