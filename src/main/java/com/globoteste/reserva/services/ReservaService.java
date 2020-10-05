package com.globoteste.reserva.services;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globoteste.reserva.domain.Estoque;
import com.globoteste.reserva.domain.Reserva;
import com.globoteste.reserva.domain.ReservaDTO;
import com.globoteste.reserva.domain.ReservaPrograma;
import com.globoteste.reserva.domain.ReservaProgramaDTO;
import com.globoteste.reserva.respositories.ReservaRepository;
import com.globoteste.reserva.utils.DateService;

import net.bytebuddy.utility.RandomString;

@Service
public class ReservaService {

	@Autowired
	private ReservaRepository repository;

	@Autowired
	private ReservaProgramaService reservaProgramaService;

	@Autowired
	private EstoqueService estoqueService;

	@Autowired
	private ApiProgramasService apiProgramasService;

	public List<Reserva> getAllReservas() {
		List<Reserva> reservas = new ArrayList<Reserva>();
		repository.findAll().forEach(reserva1 -> reservas.add(reserva1));
		return reservas;
	}

	public Reserva getReservaById(BigInteger id) {
		return repository.findById(id).get();
	}

	public String saveOrUpdate(ReservaDTO reserva) {

		String msgErro = "";
		String listaIds = apiProgramasService.getAllIds();
		Reserva reservaNova = new Reserva();
		reservaNova.setRequestId(reserva.getRequest_id());

		reservaNova.setCodigoReserva(RandomString.make(10));
		reservaNova = repository.save(reservaNova);

		List<ReservaPrograma> reservaPrograma = new ArrayList<ReservaPrograma>();
		if (reserva.getProgramas() != null && reserva.getProgramas().size() > 0) {
			for (ReservaProgramaDTO rsv : reserva.getProgramas()) {
				String msgErroLocal = "";
				ReservaPrograma rsvPg = new ReservaPrograma();

				if (rsv.getData_exibicao() != null) {
					rsvPg.setDataExibicao(DateService.convertStringToDate(rsv.getData_exibicao()));
				}
				rsvPg.setQuantidade(rsv.getQuantidade());
				rsvPg.setReserva(reservaNova);
				rsvPg.setIdPrograma(rsv.getId());
				rsvPg.setTempo(rsv.getTempo());
				// VALIDA ANTES DE ADICIONAR
				msgErroLocal = validaData(rsvPg, listaIds);
				msgErro += msgErroLocal;
				if (msgErroLocal != "") {
					reservaPrograma.add(rsvPg);
				}
			}
		}

		reservaProgramaService.saveOrUpdate(reservaPrograma);

		return "Código da Reserva : " + reservaNova.getCodigoReserva() + msgErro;

	}

	public String validaData(ReservaPrograma rsv, String listaIds) {

		String msgErro = "";

		if (listaIds.contains(rsv.getIdPrograma())) {
			Estoque estoques = estoqueService.findByDate(rsv.getDataExibicao(), rsv.getIdPrograma());

			if (estoques != null) {

				Estoque estoques2 = estoqueService.findByDateAndId(rsv.getDataExibicao(), rsv.getIdPrograma(),
						rsv.getQuantidade() * rsv.getTempo());

				if (estoques2 == null) {

					msgErro += "\r\nNão existe estoque disponível para o programa " + rsv.getIdPrograma();
				} else {
					int tempoNovo = estoques.getTempoDiponivel() - rsv.getTempo() * rsv.getQuantidade();
					estoqueService.updateQuantidades(rsv.getDataExibicao(), rsv.getIdPrograma(), tempoNovo);
				}

			} else {

				msgErro += "\r\nNão existe estoque para o programa " + rsv.getIdPrograma() + " na data solicitada";
			}
		} else {

			msgErro += "\r\nPrograma"+ rsv.getIdPrograma()+" não existente. Reserva não pode ser efetuada.";

		}

		return msgErro;

	}

	public void delete(BigInteger id) {
		repository.deleteById(id);
	}

	public void update(Reserva reserva, int id) {
		repository.save(reserva);
	}

}
