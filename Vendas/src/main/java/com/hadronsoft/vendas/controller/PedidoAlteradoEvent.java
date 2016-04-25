package com.hadronsoft.vendas.controller;

import com.hadronsoft.vendas.model.Pedido;

public class PedidoAlteradoEvent {

	private Pedido pedido;
	
	public PedidoAlteradoEvent(Pedido pedido) {
		this.pedido = pedido;
	}
	
	public Pedido getPedido(){
		return pedido;
	}
}
