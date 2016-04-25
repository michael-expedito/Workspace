package com.hadronsoft.vendas.services;

import java.io.Serializable;

import javax.inject.Inject;

import com.hadronsoft.vendas.model.Pedido;
import com.hadronsoft.vendas.model.StatusPedido;
import com.hadronsoft.vendas.repositories.PedidoRepository;
import com.hadronsoft.vendas.util.jpa.Transactional;

public class CancelamentoPedidoService implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private PedidoRepository pedRepository;;
	
	@Inject 
	private EstoqueService estoqueService;
	
	@Transactional
	public Pedido cancelar(Pedido pedido) {
		pedido = this.pedRepository.getById(pedido.getId());
		
		if (pedido.isNaoCancelavel()){
			throw new NegocioException("Pedido não pode ser cancelado no status "
					+ pedido.getStatus().getDescricao() + ".");
		}
		
		if (pedido.isEmitido()){
			this.estoqueService.retornarItensEstoque(pedido);
		}
		
		pedido.setStatus(StatusPedido.CANCELADO);
		
		pedido = this.pedRepository.salvar(pedido);
		
		return pedido;
	}

}
