package com.eventoapp.eventoapp.service;

import java.util.List;

import com.eventoapp.eventoapp.model.Evento;

public interface EventoService {
	
	Evento save(Evento evento);
	List<Evento> findAll();
	Evento findById (long id);

}
