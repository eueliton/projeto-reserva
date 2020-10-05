package com.globoteste.reserva.domain;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "estoque")
public class Estoque implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private BigInteger id;

	@Column(name = "id_programa", length = 10)
	private String idPrograma;

	@Column(name = "data_exibicao")
	private Date dataExibicao;

	@Column(name = "tempo_disponivel")
	private int tempoDiponivel;

	public Estoque() {
		super();
	}

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getIdPrograma() {
		return idPrograma;
	}

	public void setIdPrograma(String idPrograma) {
		this.idPrograma = idPrograma;
	}

	public Date getDataExibicao() {
		return dataExibicao;
	}

	public void setDataExibicao(Date dataExibicao) {
		this.dataExibicao = dataExibicao;
	}

	public int getTempoDiponivel() {
		return tempoDiponivel;
	}

	public void setTempoDiponivel(int tempoDiponivel) {
		this.tempoDiponivel = tempoDiponivel;
	}

}
