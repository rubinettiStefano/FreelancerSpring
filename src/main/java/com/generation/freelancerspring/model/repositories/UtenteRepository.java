package com.generation.freelancerspring.model.repositories;

import com.generation.freelancerspring.model.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtenteRepository extends JpaRepository<Utente, Integer>
{
}
