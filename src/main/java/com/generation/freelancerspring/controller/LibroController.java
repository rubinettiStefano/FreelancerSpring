package com.generation.freelancerspring.controller;

import com.generation.freelancerspring.controller.helpers.ControllerHelper;
import com.generation.freelancerspring.controller.helpers.ControllerHelperImpl;
import com.generation.freelancerspring.model.entities.Libro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//http://localhost:8080/libro GET
@Controller
@RequestMapping("/libro")
public class LibroController
{
	@Autowired
	private ControllerHelper helper;

	@PostMapping
	public String inserisciLibro(@ModelAttribute Libro libro)
	{
		helper.saveLibro(libro);
		return "redirect:/libro";//reindirizzami a GET /libro
	}

	//tu ti attivi quando arriva una request con verbo GET
	//il metodo NONONONON restituisce una String, ma una pagina web
	//la pagina web che si trova nella cartella templates con il nome gestoreLibro.html
	@GetMapping
	public String paginaGestioneLibri(Model model)
	{
		List<Libro> libri = helper.getAllLibris();
		model.addAttribute("libri", libri);
		return "gestoreLibro";
	}

	//http://localhost:8080/libro/dettaglio
	@GetMapping("/dettaglio")
	public String dettaglio(@RequestParam int id,Model model)
	{
		Libro libro = helper.getLibro(id);
		model.addAttribute("libro", libro);
		return "dettaglioLibro";
	}


}
