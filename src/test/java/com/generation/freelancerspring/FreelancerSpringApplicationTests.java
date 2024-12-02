package com.generation.freelancerspring;

import com.generation.freelancerspring.model.entities.Bicicletta;
import com.generation.freelancerspring.model.entities.Persona;
import com.generation.freelancerspring.model.repositories.BiciclettaRepository;
import com.generation.freelancerspring.model.repositories.PersonaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class FreelancerSpringApplicationTests {

	@Autowired
	PersonaRepository pRepo;

	@Autowired
	BiciclettaRepository bRepo;


	@Test
	void contextLoads()
	{
//		Persona claudia = pRepo.findById(2).get();
//
//		System.out.println("Le tue bici");
//		for(Bicicletta bicicletta : claudia.getBiciclette())
//			System.out.println(bicicletta);

		Bicicletta bicicletta = bRepo.findById(1).get();

		System.out.println("Sono la bicicletta di "+bicicletta.getProprietario().getNome());

	}

}
