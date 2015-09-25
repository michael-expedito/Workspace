package com.hadronsoft.vendas.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.hadronsoft.vendas.model.Cliente;
import com.hadronsoft.vendas.model.EnderecoEntrega;
import com.hadronsoft.vendas.model.FormaPagamento;
import com.hadronsoft.vendas.model.ItemPedido;
import com.hadronsoft.vendas.model.Pedido;
import com.hadronsoft.vendas.model.Produto;
import com.hadronsoft.vendas.model.Usuario;
import com.hadronsoft.vendas.repositories.ClienteRepository;
import com.hadronsoft.vendas.repositories.ProdutoRepository;
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
	
	@Inject
	private ProdutoRepository prdRepository;

	private Pedido pedido;
	private List<Usuario> vendedores;
	private List<Cliente> clientes;
	
	private Produto produtoLinhaEditavel;
	
	public CadastroPedidosBean() {
		clear();
	}
	
	public void start(){
		if (this.pedido == null){
			clear();
		}
		
		if(FacesUtil.isNotPostback()){
			this.vendedores = this.usuRepository.getVendedores();
			this.clientes = this.cliRepository.getAll();
			this.pedido.addEmptyItem();
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
	
	public List<Produto> completarProduto(String nome){
		return this.prdRepository.getByName(nome);
	}
	
	public void carregarProdutoLinhaEditavel(){
		ItemPedido item = this.pedido.getItens().get(0);
		
		if (this.produtoLinhaEditavel != null) {
			item.setProduto(this.produtoLinhaEditavel);
			item.setValorUnitario(this.produtoLinhaEditavel.getValorUnitario());
			
			this.pedido.addEmptyItem();
			this.produtoLinhaEditavel = null;
			
			this.pedido.recalcularValorTotal();
		}
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

	public Produto getProdutoLinhaEditavel() {
		return produtoLinhaEditavel;
	}

	public void setProdutoLinhaEditavel(Produto produtoLinhaEditavel) {
		this.produtoLinhaEditavel = produtoLinhaEditavel;
	}
	
	
	
	
}
