package com.generation.freelancerspring.controller;

import com.generation.freelancerspring.model.entities.Libro;
import com.generation.freelancerspring.model.repositories.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//http://localhost:8080/libro
@Controller
@RequestMapping("/libro")
public class LibroController
{
	@Autowired
	private LibroRepository repo;

	@PostMapping
	public String inserisciLibro(@ModelAttribute Libro libro)
	{
		repo.save(libro);
		return "redirect:/libro";//reindirizzami a GET /libro
	}

	//tu ti attivi quando arriva una request con verbo GET
	//il metodo NONONONON restituisce una String, ma una pagina web
	//la pagina web che si trova nella cartella templates con il nome gestoreLibro.html
	@GetMapping
	public String paginaGestioneLibri(Model model)
	{
		List<Libro> libri = repo.findAll();
		model.addAttribute("libri", libri);
		return "gestoreLibro";
	}


}
