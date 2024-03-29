package com.eduborges.characterDBZ.repositories;

import com.eduborges.characterDBZ.entities.Characters;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repositories extends JpaRepository<Characters, Long> {
    Characters findByName(String name);
}
