package com.hadronsoft.vendas.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.hadronsoft.vendas.model.Cliente;
import com.hadronsoft.vendas.model.EnderecoEntrega;
import com.hadronsoft.vendas.model.FormaPagamento;
import com.hadronsoft.vendas.model.Pedido;
import com.hadronsoft.vendas.model.Usuario;
import com.hadronsoft.vendas.repositories.ClienteRepository;
import com.hadronsoft.vendas.repositories.UsuarioRepository;
import com.hadronsoft.vendas.services.CadastroPedidoService;
import com.hadronsoft.vendas.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroPedidosBean implements Serializable{
	
	private static final long serialVersionUID = 1L; 
	
	@Inject
	private CadastroPedidoService cadastroPedidoService;
	
	@Inject
	private UsuarioRepository usuRepository;
	
	@Inject
	private ClienteRepository cliRepository;

	private Pedido pedido;
	private List<Usuario> vendedores;
	private List<Cliente> clientes;
	
	public CadastroPedidosBean() {
		clear();
	}
	
	public void start(){
		if(FacesUtil.isNotPostback()){
			this.vendedores = this.usuRepository.getVendedores();
			this.clientes = this.cliRepository.getAll();
		}
		if (this.pedido == null){
			clear();
		}
		this.recalcularPedido();
	}
	
	public void salvar(){
		this.pedido = this.cadastroPedidoService.salvar(this.pedido);
		clear();
		FacesUtil.addInfoMessage("Pedido salvo com sucesso!");
	}
		
	
	public void clear(){
		pedido = new Pedido();
		pedido.setEnderecoEntrega(new EnderecoEntrega());
	}
	
	public List<Cliente> completarCliente(String nome){
		return this.cliRepository.getByNome(nome);
	}
	
	public String getTitlePage(){
		if (pedido == null || pedido.isNew()){
			return "Novo Pedido";
		} else {
			return "Editando Pedido";
		}
	}
	
	public void recalcularPedido(){
		this.pedido.recalcularValorTotal();
	}
	
	// gets and sets
	public Pedido getPedido(){
		return pedido;
	}
	
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public FormaPagamento[] getFormasPagamentos() {
		return FormaPagamento.values();
	}

	public List<Usuario> getVendedores() {
		return vendedores;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}
	
	
	
	
}
