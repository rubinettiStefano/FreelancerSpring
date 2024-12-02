package com.generation.freelancerspring.model.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.StringJoiner;

@Entity
@Data
public class Bicicletta
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String modello;

	private int prezzo;

	//se riga=oggetto
	//dove nel db una riga di bicletta è collegata ad una riga di persona
	//allora in java un oggetto bicicletta sarà collegato a oggetto persona

	@ManyToOne
	@JoinColumn(name = "persona_id")
	private Persona proprietario;

	@Override
	public String toString()
	{
		return new StringJoiner(", ", Bicicletta.class.getSimpleName() + "[", "]")
				.add("id=" + id)
				.add("modello='" + modello + "'")
				.add("prezzo=" + prezzo)
				.toString();
	}
}
