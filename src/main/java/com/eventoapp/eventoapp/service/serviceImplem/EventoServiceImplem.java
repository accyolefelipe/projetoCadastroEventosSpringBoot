package com.eventoapp.eventoapp.service.serviceImplem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventoapp.eventoapp.model.Evento;
import com.eventoapp.eventoapp.repository.EventoRepository;
import com.eventoapp.eventoapp.service.EventoService;

@Service
public class EventoServiceImplem implements EventoService {
	@Autowired
	EventoRepository eventoRepository;

	@Override
	public Evento save(Evento evento) {
		return eventoRepository.save(evento);
	}

}
