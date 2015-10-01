package com.hadronsoft.vendas.controller;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.event.Observes;
import javax.enterprise.inject.Produces;
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

	@Produces
	@PedidoEdicao
	private Pedido pedido;
	
	private List<Usuario> vendedores;
	private List<Cliente> clientes;
	
	private Produto produtoLinhaEditavel;
	
	private String sku;
	
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
		this.pedido.removeEmptyItem();
		
		try{
			this.pedido = this.cadastroPedidoService.salvar(this.pedido);
			FacesUtil.addInfoMessage("Pedido salvo com sucesso!");
		} finally {
			this.pedido.addEmptyItem();
		}
		
		
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
			if (this.existeItemComProduto(this.produtoLinhaEditavel)) {
				FacesUtil.addErrorMessage("Já existe um item no epdido com o produto informado.");
			} else {
				item.setProduto(this.produtoLinhaEditavel);
				item.setValorUnitario(this.produtoLinhaEditavel.getValorUnitario());
	
				this.pedido.addEmptyItem();
				this.produtoLinhaEditavel = null;
				this.sku = null;
				
				this.pedido.recalcularValorTotal();
			}
		}
	}
	
	private boolean existeItemComProduto(Produto produto) {
		boolean existeItem = false;
		for (ItemPedido item : this.getPedido().getItens()){
			if (produto.equals(item.getProduto())){
				existeItem = true;
				break;
			}
		}
		return existeItem;
	}

	public void carregarProdutoPorSku(){
		if (this.sku != null && this.sku != ""){
			this.produtoLinhaEditavel = this.prdRepository.getBySku(this.sku);
			this.carregarProdutoLinhaEditavel();
		}
	}
	
	public void atualizarQuantidade(ItemPedido item, int linha){
		if (item.getQuantidade() < 1){
			if (linha == 0){
				item.setQuantidade(1);
			} else {
				this.getPedido().getItens().remove(linha);
			}
		}
		
		this.pedido.recalcularValorTotal();
	}
	
	public void pedidoAlterado(@Observes PedidoAlteradoEvent event){
		this.pedido = event.getPedido();
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

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}
	
}
