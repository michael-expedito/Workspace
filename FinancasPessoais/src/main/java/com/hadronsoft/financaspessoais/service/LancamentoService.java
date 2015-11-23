package com.hadronsoft.financaspessoais.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

import com.hadronsoft.financaspessoais.model.Cadastro;
import com.hadronsoft.financaspessoais.model.Lancamento;
import com.hadronsoft.financaspessoais.model.Parcelamento;
import com.hadronsoft.financaspessoais.model.TipoLancamento;
import com.hadronsoft.financaspessoais.repository.LancamentoRepository;
import com.hadronsoft.financaspessoais.repository.ParcelamentoRepository;
import com.hadronsoft.financaspessoais.security.SessionContext;
import com.hadronsoft.financaspessoais.util.FacesUtil;
import com.hadronsoft.financaspessoais.util.Transactional;

public class LancamentoService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private LancamentoRepository lancamentoRepository;

	@Inject
	private ParcelamentoRepository parcelamentoRepository;

	@Transactional
	public void salvar(Lancamento lancamento, Parcelamento parcelamento) throws NegocioException {
		if (lancamento.getId() != null){
			lancamentoRepository.delete(lancamento);
			lancamento.setId(null);
		}
		if (parcelamento.getQuantidadeParcelas() > 0) {
			lancamento.setCadastro((Cadastro) SessionContext.getInstance().getUsuarioLogado());
			parcelamento.setCadastro((Cadastro) SessionContext.getInstance().getUsuarioLogado());

			Calendar vencimentoTemp = Calendar.getInstance();

			List<Lancamento> lancamentos = new ArrayList<>();

			for (long i = 0; i < parcelamento.getQuantidadeParcelas(); i++) {

				Lancamento newLancamento = new Lancamento();
				newLancamento.copyTo(lancamento);
				newLancamento.setParcelamento(parcelamento);
				
				vencimentoTemp.setTime(lancamento.getDataVencimento());
				switch (parcelamento.getFrequenciaLancamento()) {
					case DIARIA:
						vencimentoTemp.add(Calendar.DAY_OF_MONTH, (int) i);
						break;
					case SEMANAL:
						vencimentoTemp.add(Calendar.WEEK_OF_MONTH, (int) i);
						break;
					case QUINZENAL:
						vencimentoTemp.add(Calendar.WEEK_OF_MONTH, (int) i*2);
						break;
					case MENSAL:
						vencimentoTemp.add(Calendar.MONTH, (int) i);
						break;
					case BIMESTRAL:
						vencimentoTemp.add(Calendar.MONTH, (int) i*2);
						break;
					case TRIMESTRAL:
						vencimentoTemp.add(Calendar.MONTH, (int) i*3);
						break;
					case SEMESTRAL:
						vencimentoTemp.add(Calendar.MONTH, (int) i*6);
						break;
					case ANUAL:
						vencimentoTemp.add(Calendar.YEAR, (int) i);
						break;
				default:
					break;
				}
				newLancamento.setDataVencimento(vencimentoTemp.getTime());
				newLancamento.setNumeroParcela(i+1);
				
				lancamentos.add(newLancamento);
			}
			parcelamento.setLancamentos(lancamentos);
			parcelamentoRepository.update(parcelamento);

		} else {
			lancamento.setCadastro((Cadastro) SessionContext.getInstance().getUsuarioLogado());
			lancamentoRepository.update(lancamento);
		}
		
		if (lancamento.getTipo() == TipoLancamento.CREDITO) {
			FacesUtil.addInfoMessage("Receita cadastrada com sucesso!");
		} else {
			FacesUtil.addInfoMessage("Despesa cadastrada com sucesso!");
		}
	}

	@Transactional
	public void excluir(Lancamento lancamento) throws NegocioException {
		lancamento = this.lancamentoRepository.getById(lancamento.getId());
		if (lancamento.getDataPagamento() != null) {
			throw new NegocioException("Não é possível excluir um lançamento pago!");
		}
		this.lancamentoRepository.delete(lancamento);
	}
}