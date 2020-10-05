package com.globoteste.reserva.domain;

import java.util.List;
import java.util.UUID;

public class ReservaDTO {

	private UUID request_id;

	private List<ReservaProgramaDTO> programas;

	public UUID getRequest_id() {
		return request_id;
	}

	public void setRequest_id(UUID request_id) {
		this.request_id = request_id;
	}

	public List<ReservaProgramaDTO> getProgramas() {
		return programas;
	}

	public void setProgramas(List<ReservaProgramaDTO> programas) {
		this.programas = programas;
	}

}
