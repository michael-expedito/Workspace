package com.hadronsoft.vendas.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.hadronsoft.vendas.model.Pedido;
import com.hadronsoft.vendas.model.StatusPedido;
import com.hadronsoft.vendas.repositories.PedidoRepository;
import com.hadronsoft.vendas.repositories.filters.PedidoFilter;

@Named
@ViewScoped
public class PesquisaPedidosBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	PedidoRepository pedRepository;
	
	private List<Pedido> pedidosFiltrados;
	private PedidoFilter filtro;
	
	public PesquisaPedidosBean() {
		filtro = new PedidoFilter();
		pedidosFiltrados = new ArrayList<>();
	}
	
	public void pesquisar(){
		pedidosFiltrados = pedRepository.getByFilter(filtro);
	}
	
	public List<Pedido> getPedidosFiltrados() {
		return pedidosFiltrados;
	}

	public PedidoFilter getFiltro() {
		return filtro;
	}

	public void setFiltro(PedidoFilter filtro) {
		this.filtro = filtro;
	}

	public void setPedidosFiltrados(List<Pedido> pedidosFiltrados) {
		this.pedidosFiltrados = pedidosFiltrados;
	}
	
	public StatusPedido[] getStatuses(){
		return StatusPedido.values();
	}
	
	
}
