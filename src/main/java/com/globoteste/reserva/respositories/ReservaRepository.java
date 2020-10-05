package com.globoteste.reserva.respositories;

import java.math.BigInteger;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.globoteste.reserva.domain.Reserva;
 
public interface ReservaRepository extends CrudRepository<Reserva, Long> {

	Optional<Reserva> findById(BigInteger id);

	void deleteById(BigInteger id);

}
