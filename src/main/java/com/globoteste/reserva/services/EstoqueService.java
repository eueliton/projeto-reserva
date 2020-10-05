package com.globoteste.reserva.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globoteste.reserva.domain.Estoque;
import com.globoteste.reserva.respositories.EstoqueRepository;

@Service
public class EstoqueService {

	@Autowired
	private EstoqueRepository repository;

	public List<Estoque> getAllEstoques() {
		List<Estoque> estoques = new ArrayList<Estoque>();
		repository.findAll().forEach(estoque1 -> estoques.add(estoque1));
		return estoques;
	}

	public Estoque findByDate(Date dataExibicao, String idPrograma) {

		return repository.findByDate(dataExibicao, idPrograma);
	}

	public Estoque findByDateAndId(Date dataExibicao, String idPrograma, int tempoNecessario) {

		return repository.findByDateAndId(dataExibicao, idPrograma, tempoNecessario);
	}

	public void updateQuantidades(Date dataExibicao, String idPrograma, int tempoNovo) {
			repository.updateQuantidades(tempoNovo, dataExibicao, idPrograma);

	}

}
