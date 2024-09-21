package com.tcna.springdatajpa.pruebas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.tcna.springdatajpa.entities.entity4.Automovil;
import com.tcna.springdatajpa.entities.entity4.Propietario;
import com.tcna.springdatajpa.repositories.repository4.AutomovilRepository;
import com.tcna.springdatajpa.repositories.repository4.PropietarioRepository;

@Component
public class prueba004 implements CommandLineRunner {
    // Inyectamos los repositorios que hemos creado
    @Autowired
    private AutomovilRepository automovilRepository;

    @Autowired
    private PropietarioRepository propietarioRepository;

    // Creamos el programa principal
    @Override
    public void run(String... args) throws Exception {
        Propietario propietario = new Propietario();
        propietario.setNombre("Juanito Alimaña");

        Automovil automovil = new Automovil();
        automovil.setMarca("Toyota");
        automovil.setMarca("Camry");

        // Debe de cambiarse en ambos porque es bidireccional
        propietario.setAutomovil(automovil);
        automovil.setPropietario(propietario);

        propietarioRepository.save(propietario);
        automovilRepository.save(automovil);

        //Leer un propietario
        Long propietarioId = propietario.getId();
        Propietario propietarioLeido = propietarioRepository.findById(propietarioId).orElse(null);
        if (propietarioLeido != null) {
            System.out.println("Propietario leido: " + propietarioLeido.getNombre());
        }

        //Actualizar el automovil asociado al propietario
        Automovil automovilUpdate = propietario.getAutomovil();
        automovilUpdate.setMarca("Honda");
        automovilUpdate.setModelo("Accord");
        automovilRepository.save(automovilUpdate);

        //Eliminar el propietario y su automovil
        propietarioRepository.delete(propietario);

        //Veridifar si el propietario ha sido eliminado
        Propietario propietarioDelete = propietarioRepository.findById(propietarioId).orElse(null);
        if(propietarioDelete == null){
            System.out.println("Propietario eliminado con exito!");
        }
    }

}
