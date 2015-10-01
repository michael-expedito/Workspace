package com.hadronsoft.vendas.controller;

import java.io.Serializable;

import javax.enterprise.event.Event;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.hadronsoft.vendas.model.Pedido;
import com.hadronsoft.vendas.services.EmissaoPedidoService;
import com.hadronsoft.vendas.util.jsf.FacesUtil;

@Named
@ViewScoped
public class EmissaoPedidosBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EmissaoPedidoService emissaoPedidoService;
	
	@Inject
	@PedidoEdicao
	private Pedido pedido;
	
	@Inject
	private Event<PedidoAlteradoEvent> pedidoAlteradoEvent;
	
	public void emitirPedido(){
		
		this.pedido.removeEmptyItem();

		try {
			this.pedido = emissaoPedidoService.emitir(this.pedido);
			this.pedidoAlteradoEvent.fire(new PedidoAlteradoEvent(pedido));
			
			FacesUtil.addInfoMessage("Pedido emitido com sucesso!");
			
		} finally {
			this.pedido.addEmptyItem();
		}
	}

	
}
