package com.hadronsoft.financaspessoais.service;

import java.io.Serializable;
import java.util.Date;

import javax.inject.Inject;

import com.hadronsoft.financaspessoais.model.Cadastro;
import com.hadronsoft.financaspessoais.model.Lancamento;
import com.hadronsoft.financaspessoais.model.Parcelamento;
import com.hadronsoft.financaspessoais.repository.LancamentoRepository;
import com.hadronsoft.financaspessoais.security.SessionContext;
import com.hadronsoft.financaspessoais.service.NegocioException;
import com.hadronsoft.financaspessoais.util.Transactional;

public class CadastroLancamentos implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private LancamentoRepository lancamentoRepository;

	@Transactional
	public void salvar(Lancamento lancamento) throws NegocioException {
		if (lancamento.getDataPagamento() != null && lancamento.getDataPagamento().after(new Date())) {
			throw new NegocioException("Data de pagamento não pode ser uma data futura.");
		}
		this.lancamentoRepository.update(lancamento);
	}
	
	public void salvarReceita(Lancamento lancamento, Parcelamento parcelamento){
		if (parcelamento != null){
			
		} else {
			lancamento.setCadastro((Cadastro) SessionContext.getInstance().getUsuarioLogado());
			lancamentoRepository.add(lancamento);
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
