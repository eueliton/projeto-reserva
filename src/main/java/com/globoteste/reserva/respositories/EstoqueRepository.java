package com.globoteste.reserva.respositories;

import java.util.Date;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.globoteste.reserva.domain.Estoque;

public interface EstoqueRepository extends CrudRepository<Estoque, Long> {

	@Query("SELECT c from Estoque c  WHERE data_exibicao = ?1 and  id_programa = ?2")
	Estoque findByDate(Date data,  String id_programa);
	 
	@Query("SELECT c from Estoque c  WHERE data_exibicao = ?1 and id_programa = ?2 and tempo_disponivel >= ?3")
	Estoque findByDateAndId(Date data,  String id_programa, int tempo_necessario);

	@Transactional
	@Modifying
	@Query("UPDATE Estoque c set tempo_disponivel = :tempo_novo WHERE data_exibicao = :data and id_programa = :id_programa")
	void updateQuantidades(@Param("tempo_novo") int tempoNovo, @Param("data") Date data,
			@Param("id_programa") String id_programa);
		
}
