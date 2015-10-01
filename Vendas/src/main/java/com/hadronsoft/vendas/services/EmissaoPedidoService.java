package com.hadronsoft.vendas.services;

import java.io.Serializable;

import javax.inject.Inject;

import com.hadronsoft.vendas.model.Pedido;
import com.hadronsoft.vendas.model.StatusPedido;
import com.hadronsoft.vendas.repositories.PedidoRepository;

public class EmissaoPedidoService implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private CadastroPedidoService cadastroPedidoService;
	
	@Inject
	private PedidoRepository pedRepository;
	
	@Inject
	private EstoqueService estoqueService;
	
	public Pedido emitir(Pedido pedido) {
		pedido = this.cadastroPedidoService.salvar(pedido);
		
		if (pedido.isNaoEmissivel()) {
			throw new NegocioException("Pedido não pode ser emitido com status " 
					+ pedido.getStatus().getDescricao());
		}
		
		this.estoqueService.baixarItensEstoque(pedido);
		
		pedido.setStatus(StatusPedido.EMITIDO);
		
		pedRepository.salvar(pedido);
		
		return pedido;
	}
	
	
}
