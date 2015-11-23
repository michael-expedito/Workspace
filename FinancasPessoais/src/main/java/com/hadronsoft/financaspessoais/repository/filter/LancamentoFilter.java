package com.hadronsoft.financaspessoais.repository.filter;

import java.util.Date;

import com.hadronsoft.financaspessoais.model.Conta;

public class LancamentoFilter {
	private Date periodoInicial;
	private Date periodoFinal;
	private Conta conta;
	
	public Date getPeriodoInicial() {
		return periodoInicial;
	}
	public void setPeriodoInicial(Date periodoInicial) {
		this.periodoInicial = periodoInicial;
	}
	public Date getPeriodoFinal() {
		return periodoFinal;
	}
	public void setPeriodoFinal(Date periodoFinal) {
		this.periodoFinal = periodoFinal;
	}
	public Conta getConta() {
		return conta;
	}
	public void setConta(Conta conta) {
		this.conta = conta;
	}
	
	
}
