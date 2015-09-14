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
		return pedRepository.salvar(pedido);
	}
}
