package com.generation.freelancerspring.model.repositories;

import com.generation.freelancerspring.model.entities.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<Libro, Integer>
{
}
