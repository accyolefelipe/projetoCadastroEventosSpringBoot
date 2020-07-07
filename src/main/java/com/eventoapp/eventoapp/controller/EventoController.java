package com.eventoapp.eventoapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.eventoapp.eventoapp.model.Convidado;
import com.eventoapp.eventoapp.model.Evento;
import com.eventoapp.eventoapp.service.ConvidadoService;
import com.eventoapp.eventoapp.service.EventoService;

@Controller
public class EventoController {
	@Autowired
	EventoService eventoService;
	
	@Autowired
	ConvidadoService convidadoService;

	@RequestMapping(value = "/cadastrarEvento", method = RequestMethod.GET)
	public String form() {
		return "evento/formEvento";
	}

	@RequestMapping(value = "/cadastrarEvento", method = RequestMethod.POST)
	public String saveform(@Valid Evento evento, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique se os campos foram preenchidos!");
			return "redirect:/cadastrarEvento";
		}
		else {
		eventoService.save(evento);
		attributes.addFlashAttribute("mensagem", "Evento cadastrado com sucesso!!");
		return "redirect:/cadastrarEvento";
		}
	}
	

	@RequestMapping(value = "/eventos" , method = RequestMethod.GET)
	public ModelAndView getEventos() {
		ModelAndView mv = new ModelAndView("index");
		List<Evento> eventos = eventoService.findAll();
		mv.addObject("eventos", eventos);
		return mv;
	}
	
	@RequestMapping(value = "/eventos{id}" , method = RequestMethod.GET)
	public ModelAndView detailEvento(@PathVariable("id") long id) {
		ModelAndView mv = new ModelAndView("evento/detailEvento");
		Evento evento = eventoService.findById(id);
		mv.addObject("evento" , evento);
		
		List<Convidado> convidados = convidadoService.findByEvento(evento);
		mv.addObject("convidados" , convidados);
		return mv;
	}
	
	@RequestMapping(value = "/eventos{id}" , method = RequestMethod.POST)
	public String detailEventoPost(@PathVariable("id") long id , @Valid Convidado convidado, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique se os campos foram preenchidos!");
			return "redirect:/eventos{id}";
		}
		else {
		Evento evento = eventoService.findById(id);
		convidado.setEvento(evento);
		convidadoService.save(convidado);
		attributes.addFlashAttribute("mensagem", "Convidado cadastrado com sucesso!!");
		return "redirect:/eventos{id}";
		}
	}

}
