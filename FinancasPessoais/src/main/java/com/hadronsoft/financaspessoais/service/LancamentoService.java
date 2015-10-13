package com.hadronsoft.financaspessoais.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import com.hadronsoft.financaspessoais.model.Cadastro;
import com.hadronsoft.financaspessoais.model.Lancamento;
import com.hadronsoft.financaspessoais.model.Parcelamento;
import com.hadronsoft.financaspessoais.model.TipoLancamento;
import com.hadronsoft.financaspessoais.repository.LancamentoRepository;
import com.hadronsoft.financaspessoais.repository.ParcelamentoRepository;
import com.hadronsoft.financaspessoais.security.SessionContext;
import com.hadronsoft.financaspessoais.util.Transactional;

public class LancamentoService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private LancamentoRepository lancamentoRepository;
	
	@Inject
	private ParcelamentoRepository parcelamentoRepository;

	@Transactional
	public void salvar(Lancamento lancamento) throws NegocioException {
		if (lancamento.getDataPagamento() != null && lancamento.getDataPagamento().after(new Date())) {
			throw new NegocioException("Data de pagamento não pode ser uma data futura.");
		}
		this.lancamentoRepository.update(lancamento);
	}
	
	@Transactional
	public void salvarReceita(Lancamento lancamento, Parcelamento parcelamento){
		if (parcelamento != null){
			
			List<Lancamento> lancamentos = new ArrayList<>();
			
			for (long i = 1; i < parcelamento.getQuantidadeParcelas(); i++) {
				
				Lancamento newLancamento = new Lancamento();
				newLancamento.setTipo(TipoLancamento.CREDITO);
				newLancamento.setCadastro((Cadastro) SessionContext.getInstance().getUsuarioLogado());
				newLancamento.setCategoria(lancamento.getCategoria());
				newLancamento.setConta(lancamento.getConta());
				newLancamento.setDataDesconto(lancamento.getDataDesconto());
				newLancamento.setDataPagamento(lancamento.getDataPagamento());
				newLancamento.setDataVencimento( lancamento.getDataVencimento());
				newLancamento.setDescricao(lancamento.getDescricao());
				newLancamento.setNumeroParcela(i);
				newLancamento.setObservacoes(lancamento.getObservacoes());
				newLancamento.setParcelamento(parcelamento);
				newLancamento.setTipo(lancamento.getTipo());
				newLancamento.setValor(lancamento.getValor());
				newLancamento.setValorDesconto(lancamento.getValorDesconto());
				lancamentos.add(newLancamento);
			}
			
			parcelamento.setCadastro((Cadastro) SessionContext.getInstance().getUsuarioLogado());
			parcelamento.setLancamentos(lancamentos);
			
			parcelamentoRepository.add(parcelamento);
			
		} else {
			lancamento.setTipo(TipoLancamento.CREDITO);
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