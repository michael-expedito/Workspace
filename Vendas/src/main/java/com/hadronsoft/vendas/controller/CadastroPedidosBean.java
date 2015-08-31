package com.hadronsoft.vendas.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.hadronsoft.vendas.model.Pedido;

@Named
@ViewScoped
public class CadastroPedidosBean implements Serializable{
	
	private static final long serialVersionUID = 1L; 
	
	private List<Integer> itens;
	private Pedido pedido;
	
	public CadastroPedidosBean() {
		itens = new ArrayList<>();
		pedido = new Pedido();
		itens.add(1);
	}
	
	public void salvar(){
		
	}
	
	public List<Integer> getItens(){
		return itens;
	}
	
	public Pedido getPedido(){
		return pedido;
	}
}
