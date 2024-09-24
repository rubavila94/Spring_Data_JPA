package com.tcna.springdatajpa.pruebas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.tcna.springdatajpa.entities.entity5.Equipo;
import com.tcna.springdatajpa.entities.entity5.Jugador;
import com.tcna.springdatajpa.repositories.repository5.EquipoRepository;
import com.tcna.springdatajpa.repositories.repository5.JugadorRepository;

//Inyectamos los repositorios que hemos creado
@Component

//Transactional asegura que todas las operaciones en el método
//se ejecutan dentro de una sola transaccion

@Transactional
public class prueba005 implements CommandLineRunner {
    @Autowired
    private EquipoRepository equipoRepository;

    @Autowired
    private JugadorRepository jugadorRepository;

    @Override
    public void run(String... args) throws Exception {
        Equipo equipo = new Equipo();
        equipo.setNombre("Equipo de futbol");

        Jugador jugador1 = new Jugador();
        jugador1.setNombre("Ruben Avila");
        jugador1.setNumeroCamiseta(7);

        Jugador jugador2 = new Jugador();
        jugador2.setNombre("Cristian Avila");
        jugador2.setNumeroCamiseta(22);

        equipo.getJugadores().add(jugador1);
        equipo.getJugadores().add(jugador2);

        equipoRepository.save(equipo);

        // Leer el equipo y sus jugadores
        Equipo equipoGuardado = equipoRepository.findById(equipo.getId()).orElse(null);
        if (equipoGuardado != null) {
            System.out.println("Equipo guardado: " + equipoGuardado.getNombre());
            System.out.println("jugadores en el equipo (Usando LAZY)");
            for (Jugador jugador : equipo.getJugadores()) {
                System.out.println("-" + jugador.getNombre() + ", Camiseta #" + jugador.getNumeroCamiseta() + ")");
            }
        }

        // Realizar operaciones de actualizacion y eliminacion
        if (equipoGuardado != null) {
            // Actualizar jugador en el equipo
            Jugador jugadorActualizado = equipoGuardado.getJugadores().get(0);
            jugadorActualizado.setNumeroCamiseta(12);

            // No es necesario guardar el equipo ya que los updates se aplican
            // automaticamente debido al Cascade de tipo Merge

            // Leer el equipo y sus jugadores nuevamente
            Equipo equipoActualizado = equipoRepository.findById(equipo.getId()).orElse(null);
            if (equipoActualizado != null) {
                System.out.println("Equipo actualizado: " + equipoActualizado.getNombre());
                System.out.println("Jugadores actualizados: ");
                for (Jugador jugador : equipoActualizado.getJugadores()) {
                    System.out.println("-" + jugador.getNombre() + ", Camiseta #" + jugador.getNumeroCamiseta() + ")");
                }

                // Eliminar un jugador del equipo
                equipoActualizado.getJugadores().remove(1);

                // No es necesario guardar el equipo ya que los updates se aplican
                // automaticamente debido al Cascade de tipo Merge
                equipoRepository.delete(equipoActualizado);
            }
        }
        //Verificamos si el equipo ha sido eliminado
        Equipo equipoEliminado = equipoRepository.findById(equipo.getId()).orElse(null);
        if(equipoEliminado == null){
            System.out.println("Equipo eliminado con exito!");
        }
    }
}
