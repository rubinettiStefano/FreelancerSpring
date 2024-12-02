package com.generation.freelancerspring.controller.helpers;

import com.generation.freelancerspring.exceptions.InvalidCredentialsException;
import com.generation.freelancerspring.model.entities.Bicicletta;
import com.generation.freelancerspring.model.entities.Libro;
import com.generation.freelancerspring.model.entities.Utente;
import com.generation.freelancerspring.model.repositories.BiciclettaRepository;
import com.generation.freelancerspring.model.repositories.LibroRepository;
import com.generation.freelancerspring.model.repositories.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//@Component //prendi questa classe, istanziala all'avvio del programma e mettila nell'Application Context
@Service
public class ControllerHelperImpl implements ControllerHelper
{
	@Autowired
	private BiciclettaRepository biciRepo;
	@Autowired
	private LibroRepository libroRepo;
	@Autowired
	private UtenteRepository uteRepo;


	@Override
	public void saveLibro(Libro l)
	{
		libroRepo.save(l);
	}

	@Override
	public Libro getLibro(int id)
	{
		return libroRepo.findById(id).get();
	}

	@Override
	public List<Libro> getAllLibris()
	{
		return libroRepo.findAll();
	}

	@Override
	public void saveBicicletta(Bicicletta b)
	{
		biciRepo.save(b);
	}

	@Override
	public Bicicletta getBicicletta(int id)
	{
		return biciRepo.findById(id).get();
	}

	@Override
	public List<Bicicletta> getAllBiciclettes()
	{
		return biciRepo.findAll();
	}

	@Override
	public Utente getUtenteByUsnAndPwd(String usn, String pwd) throws InvalidCredentialsException
	{
		Utente res = null;
		List<Utente> all = uteRepo.findAll();
		for (Utente u : all)
			if (u.getNomeUtente().equals(usn) && u.getParolaSicurezza().equals(pwd))
				res = u;

		if (res == null)
			throw new InvalidCredentialsException();

		return res;
	}
}
