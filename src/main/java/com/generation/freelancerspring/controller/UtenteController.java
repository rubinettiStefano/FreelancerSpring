package com.generation.freelancerspring.controller;

import com.generation.freelancerspring.controller.helpers.ControllerHelper;
import com.generation.freelancerspring.exceptions.InvalidCredentialsException;
import com.generation.freelancerspring.model.entities.TipoUtente;
import com.generation.freelancerspring.model.entities.Utente;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalTime;

@Controller
@RequestMapping("/login")
public class UtenteController
{
	@Autowired
	ControllerHelper helper;

	@PostMapping
	public String login(@RequestParam String nomeUtente, @RequestParam String parolaSicurezza,@RequestParam String nomeProprieta, HttpSession session)
	{
		TipoUtente t = TipoUtente.valueOf(nomeProprieta.toUpperCase());
		if(!t.equals(TipoUtente.ADMIN))
			throw new InvalidCredentialsException();
		//per fare logout ci basta cancellare la session
		//session.invalidate();

		Utente u = helper.getUtenteByUsnAndPwd(nomeUtente, parolaSicurezza);
		session.setAttribute("utente", u);
		if(u.getNomeUtente().equals("Stefano"))
			session.setAttribute("tipo", TipoUtente.ADMIN);//"ADMIN"
		session.setAttribute("loginHour", LocalTime.now());
		return "loginSucc";
	}
}
