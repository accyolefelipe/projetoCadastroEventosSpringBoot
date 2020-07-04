package com.eventoapp.eventoapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.eventoapp.eventoapp.model.Evento;
import com.eventoapp.eventoapp.service.EventoService;

@Controller
public class EventoController {
	@Autowired
	EventoService eventoService;

	@RequestMapping(value = "/cadastrarEvento", method = RequestMethod.GET)
	public String form() {
		return "evento/formEvento";
	}

	@RequestMapping(value = "/cadastrarEvento", method = RequestMethod.POST)
	public String saveform(Evento evento) {
		eventoService.save(evento);
		return "redirect:/eventos";
	}

	@RequestMapping(value = "/eventos" , method = RequestMethod.GET)
	public ModelAndView getEventos() {
		ModelAndView mv = new ModelAndView("index");
		List<Evento> eventos = eventoService.findAll();
		mv.addObject("eventos", eventos);
		return mv;
	}

}
