package com.eventoapp.eventoapp.service.serviceImplem;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventoapp.eventoapp.model.Convidado;
import com.eventoapp.eventoapp.model.Evento;
import com.eventoapp.eventoapp.repository.ConvidadoRepository;
import com.eventoapp.eventoapp.service.ConvidadoService;

@Service
public class ConvidadoServiceImplem implements ConvidadoService {
	@Autowired
	ConvidadoRepository convidadoRepository;

	@Override
	public Convidado save(Convidado convidado) {
		return convidadoRepository.save(convidado);
	}

	@Override
	public List<Convidado> findByEvento(Evento evento) {
		return convidadoRepository.findByEvento(evento);
	}

}
