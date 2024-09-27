package com.tcna.springdatajpa.repositories.repository6;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tcna.springdatajpa.entities.entity6.Aerolinea;

@Repository
public interface AerolineaRepository extends JpaRepository<Aerolinea,Long>{

}
