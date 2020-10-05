package com.globoteste.reserva.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globoteste.reserva.domain.ReservaPrograma;
import com.globoteste.reserva.respositories.ReservaProgramaRepository;

@Service
public class ReservaProgramaService {

	@Autowired
	private ReservaProgramaRepository repository;

	public void saveOrUpdate(List<ReservaPrograma> reservaPrograma) {

		repository.saveAll(reservaPrograma);

	}
}
