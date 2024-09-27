package com.tcna.springdatajpa.repositories.repository7;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tcna.springdatajpa.entities.entity7.Alumno;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Long>{

}
