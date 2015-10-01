package com.hadronsoft.vendas.services;

import java.io.Serializable;

import javax.inject.Inject;

import com.hadronsoft.vendas.model.ItemPedido;
import com.hadronsoft.vendas.model.Pedido;
import com.hadronsoft.vendas.repositories.PedidoRepository;
import com.hadronsoft.vendas.util.jpa.Transactional;

public class EstoqueService implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private PedidoRepository pedRepository;
	
	@Transactional
	public void baixarItensEstoque(Pedido pedido) {
		pedido = this.pedRepository.getById(pedido.getId());
		
		for (ItemPedido item : pedido.getItens()){
			item.getProduto().baixarEstoque(item.getQuantidade());
		}
	}
}
