package org.ejemplo.crud.repository;

import org.ejemplo.crud.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Integer> {
}
