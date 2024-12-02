package com.generation.freelancerspring.model.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

@Entity
@Data

public class Persona
{
	//id primary key auto_increment
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String nome;

	private String surname;



	@OneToMany(mappedBy = "proprietario", fetch = FetchType.EAGER)
	private List<Bicicletta> biciclette = new ArrayList<>();
}
