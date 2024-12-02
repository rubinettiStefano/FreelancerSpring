package com.generation.freelancerspring.controller.helpers;

import com.generation.freelancerspring.exceptions.InvalidCredentialsException;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UniversalExceptionsCatcher
{

	//catch(InvalidCredentialsException e)
	@ExceptionHandler(InvalidCredentialsException.class)
	public String invalidLogin(InvalidCredentialsException e, Model model)
	{
		
		return "index";
	}
}
