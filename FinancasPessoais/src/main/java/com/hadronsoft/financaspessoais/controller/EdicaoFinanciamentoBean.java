package com.hadronsoft.financaspessoais.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.hadronsoft.financaspessoais.model.Parcelamento;

@Named
@SessionScoped
public class EdicaoFinanciamentoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Parcelamento parcelamento;

	public Parcelamento getParcelamento() {
		return parcelamento;
	}

	public void setParcelamento(Parcelamento parcelamento) {
		this.parcelamento = parcelamento;
	}
	
}
