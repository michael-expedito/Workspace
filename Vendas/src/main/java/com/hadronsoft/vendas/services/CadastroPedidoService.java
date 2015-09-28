package com.hadronsoft.vendas.services;

import java.io.Serializable;
import java.util.Date;

import javax.inject.Inject;

import com.hadronsoft.vendas.model.Pedido;
import com.hadronsoft.vendas.model.StatusPedido;
import com.hadronsoft.vendas.repositories.PedidoRepository;
import com.hadronsoft.vendas.util.jpa.Transactional;

public class CadastroPedidoService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private PedidoRepository pedRepository;
	
	@Transactional
	public Pedido salvar(Pedido pedido){
		if (pedido.isNew()) {
			pedido.setDataCriacao(new Date());
			pedido.setStatus(StatusPedido.ORCAMENTO);
		}
		
		pedido.recalcularValorTotal();
		
		if (pedido.getItens().isEmpty()){
			throw new NegocioException("O pedido deve possuir pelo menos um item.");
		}
		
		if (pedido.isValorTotalNegativo()){
			throw new NegocioException("O valor total do pedido não pode ser negativo.");
		}
		return pedRepository.salvar(pedido);
	}
}
