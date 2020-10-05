package com.globoteste.reserva.domain;

public class ReservaProgramaDTO {

	private String id;

	private String data_exibicao;

	private int quantidade;

	private int tempo;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getData_exibicao() {
		return data_exibicao;
	}

	public void setData_exibicao(String data_exibicao) {
		this.data_exibicao = data_exibicao;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public int getTempo() {
		return tempo;
	}

	public void setTempo(int tempo) {
		this.tempo = tempo;
	}

}
