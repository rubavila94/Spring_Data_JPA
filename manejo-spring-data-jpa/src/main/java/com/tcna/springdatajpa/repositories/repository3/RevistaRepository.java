package com.tcna.springdatajpa.repositories.repository3;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tcna.springdatajpa.entities.entity3.Revista;

@Repository
public interface RevistaRepository extends JpaRepository<Revista, Long>{

}
