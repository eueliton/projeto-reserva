package com.globoteste.reserva.domain;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "reserva")
public class Reserva implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private BigInteger id;

	@Column(name = "codigo_reserva", length = 10)
	private String codigoReserva;

	@Column(name = "data_cadastro")
	@CreationTimestamp
	private Date dataCadastro;

	@Type(type = "uuid-char")
	@Column(name = "request_id")
	private UUID requestId;
	
	@OneToMany(mappedBy = "reserva", cascade = CascadeType.ALL)
	private List<ReservaPrograma> reservaPrograma;

	public Reserva() {
		super();
	}

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getCodigoReserva() {
		return codigoReserva;
	}

	public void setCodigoReserva(String codigoReserva) {
		this.codigoReserva = codigoReserva;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public UUID getRequestId() {
		return requestId;
	}

	public void setRequestId(UUID requestId) {
		this.requestId = requestId;
	}

	public List<ReservaPrograma> getReservaPrograma() {
		return reservaPrograma;
	}

	public void setReservaPrograma(List<ReservaPrograma> reservaPrograma) {
		this.reservaPrograma = reservaPrograma;
	}

	 
	
}
