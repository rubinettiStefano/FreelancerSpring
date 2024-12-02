package com.generation.freelancerspring.model.repositories;

import com.generation.freelancerspring.model.entities.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Integer>
{
}
