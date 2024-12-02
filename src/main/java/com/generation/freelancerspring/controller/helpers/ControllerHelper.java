package com.generation.freelancerspring.controller.helpers;

import com.generation.freelancerspring.exceptions.InvalidCredentialsException;
import com.generation.freelancerspring.model.entities.Bicicletta;
import com.generation.freelancerspring.model.entities.Libro;
import com.generation.freelancerspring.model.entities.Utente;

import java.util.List;

public interface ControllerHelper
{
	void saveLibro(Libro l);
	Libro getLibro(int id);
	List<Libro> getAllLibris();
	void saveBicicletta(Bicicletta b);
	Bicicletta getBicicletta(int id);
	List<Bicicletta> getAllBiciclettes();

	Utente getUtenteByUsnAndPwd(String usn, String pwd)throws InvalidCredentialsException;
}
