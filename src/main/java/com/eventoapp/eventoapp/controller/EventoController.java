package com.eventoapp.eventoapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eventoapp.eventoapp.model.Evento;
import com.eventoapp.eventoapp.service.EventoService;

@Controller
public class EventoController {
	@Autowired
	EventoService eventoService;
	
	
	@RequestMapping(value="/cadastrarEvento", method=RequestMethod.GET)
	public String form() {
		return "evento/formEvento";
	}
	
	@RequestMapping(value="/cadastrarEvento", method=RequestMethod.POST)
	public String saveform(Evento evento) {
		eventoService.save(evento);
		return "redirect:/cadastrarEvento";
	}

}
