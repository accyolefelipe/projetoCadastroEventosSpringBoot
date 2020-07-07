package com.eventoapp.eventoapp.service;

import java.util.List;

import com.eventoapp.eventoapp.model.Convidado;
import com.eventoapp.eventoapp.model.Evento;

public interface ConvidadoService {
	
	Convidado save(Convidado convidado);
	List<Convidado> findByEvento (Evento evento);

}
