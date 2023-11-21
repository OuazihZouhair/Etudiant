package com.mba.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mba.entities.Etudiant;


public interface EtudiantRepository extends JpaRepository<Etudiant, Integer> {

}
