package com.tcna.springdatajpa.repositories.repository4;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tcna.springdatajpa.entities.entity4.Propietario;

@Repository
public interface PropietarioRepository extends JpaRepository <Propietario, Long> {

}
