package com.generation.freelancerspring.model.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Utente
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String nomeUtente;
	private String parolaSicurezza;//password

	@Enumerated(EnumType.STRING)
	private TipoUtente tipo;
}
