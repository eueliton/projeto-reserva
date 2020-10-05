package com.globoteste.reserva.resources;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globoteste.reserva.domain.Reserva;
import com.globoteste.reserva.domain.ReservaDTO;
import com.globoteste.reserva.services.ReservaService;

@RestController
@RequestMapping(path = "/reserva")
public class ReservaResource {

	@Autowired
	ReservaService reservaService;

	@GetMapping("/all")
	private List<Reserva> getAllReservas() {
		return reservaService.getAllReservas();
	}

	@GetMapping("/view/{id}")
	private Reserva getReserva(@PathVariable("id") BigInteger id) {
		return reservaService.getReservaById(id);
	}

	@DeleteMapping("/delete/{id}")
	private void deleteResereva(@PathVariable("id") BigInteger id) {
		reservaService.delete(id);
	}

	@PostMapping("/add")
	private String savePrograma(@RequestBody ReservaDTO reserva) {

		return reservaService.saveOrUpdate(reserva);

	}

	@PutMapping("/updateReserva")
	private ReservaDTO update(@RequestBody ReservaDTO reserva) {
		reservaService.saveOrUpdate(reserva);
		return reserva;
	}

}
