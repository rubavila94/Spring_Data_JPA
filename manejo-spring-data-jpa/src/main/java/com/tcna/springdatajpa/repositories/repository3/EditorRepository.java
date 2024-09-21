package com.tcna.springdatajpa.repositories.repository3;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tcna.springdatajpa.entities.entity3.Editor;

@Repository
public interface EditorRepository extends JpaRepository<Editor, Long> {

}
