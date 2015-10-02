package com.hadronsoft.vendas.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "PEDIDO_PED")
public class Pedido implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name = "PED_ID")
	private Long id;
	
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "PED_DTCRIACAO", nullable = false)
	private Date dataCriacao;
	
	@Column(name="PED_TXOBSERVACAO", columnDefinition = "TEXT")
	private String observacao;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	@Column(name = "PED_DTENTREGA", nullable = false)
	private Date dataEntrega;
	
	@NotNull
	@Column(name = "PED_VLFRETE", nullable = false, precision = 23, scale = 9)
	private BigDecimal valorFrete = BigDecimal.ZERO;;
	
	@NotNull
	@Column(name = "PED_VLDESCONTO", nullable = false, precision = 23, scale = 9)
	private BigDecimal valorDesconto = BigDecimal.ZERO;;
	
	@NotNull
	@Column(name = "PED_VLTOTAL", nullable = false, precision = 23, scale = 9)
	private BigDecimal valorTotal = BigDecimal.ZERO;;
	
	@NotNull
	@Enumerated(EnumType.ORDINAL)
	@Column(name="PED_STATUS", nullable = false)
	private StatusPedido status = StatusPedido.ORCAMENTO;
	
	@NotNull
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "PED_FORMAPAGAMENTO", nullable = false)
	private FormaPagamento formaPagamento;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "PED_IDUSUARIOVENDEDOR", nullable = false,  foreignKey = @ForeignKey(name="FK1_PEDIDO_USUARIO"))
	private Usuario vendedor;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "PED_IDCLIENTE", nullable = false,  foreignKey = @ForeignKey(name="FK2_PEDIDO_CLIENTE"))
	private Cliente cliente;
	
	@Embedded
	private EnderecoEntrega enderecoEntrega;
	
	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ItemPedido> itens = new ArrayList<>();

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Date getDataEntrega() {
		return dataEntrega;
	}
	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public BigDecimal getValorFrete() {
		return valorFrete;
	}
	public void setValorFrete(BigDecimal valorFrete) {
		this.valorFrete = valorFrete;
	}

	public BigDecimal getValorDesconto() {
		return valorDesconto;
	}
	public void setValorDesconto(BigDecimal valorDesconto) {
		this.valorDesconto = valorDesconto;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public StatusPedido getStatus() {
		return status;
	}
	public void setStatus(StatusPedido status) {
		this.status = status;
	}

	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}
	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public Usuario getVendedor() {
		return vendedor;
	}
	public void setVendedor(Usuario vendedor) {
		this.vendedor = vendedor;
	}

	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public EnderecoEntrega getEnderecoEntrega() {
		return enderecoEntrega;
	}
	public void setEnderecoEntrega(EnderecoEntrega enderecoEntrega) {
		this.enderecoEntrega = enderecoEntrega;
	}

	public List<ItemPedido> getItens() {
		return itens;
	}
	public void setItens(List<ItemPedido> itens) {
		this.itens = itens;
	}

	@Transient
	public boolean isNew(){
		return getId() == null;
	}
	
	@Transient
	public boolean isExisten(){
		return !isNew();
	}
	
	@Transient
	public BigDecimal getValorSubtotal() {
		return this.getValorTotal().subtract(this.getValorFrete()).add(this.getValorDesconto());
	}
	
	public void recalcularValorTotal() {
		BigDecimal total = BigDecimal.ZERO;
		
		total = total.add(this.getValorFrete()).subtract(this.getValorDesconto());
		
		for (ItemPedido item : this.getItens()) {
			if (item.getProduto() != null && item.getProduto().getId() != null) {
				total = total.add(item.getValorTotal());
			}
		}
		
		this.setValorTotal(total);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	public void addEmptyItem() {
		if (this.isOrcamento()){
			Produto produto = new Produto();
		
			ItemPedido item = new ItemPedido();
			item.setQuantidade(1);
			item.setProduto(produto);
			item.setPedido(this);
			
			this.getItens().add(0, item);
		}
		
	}
	
	@Transient
	public boolean isOrcamento() {
		return StatusPedido.ORCAMENTO.equals(this.getStatus());
	}
	public void removeEmptyItem() {
		ItemPedido primeiroItem = this.getItens().get(0);
		
		if (primeiroItem != null && primeiroItem.getProduto().getId() == null) {
			this.getItens().remove(0);
		}
		
	}
	
	@Transient
	public boolean isValorTotalNegativo() {
		return this.getValorTotal().compareTo(BigDecimal.ZERO) < 0;
	}
	public boolean isEmitido() {
		return StatusPedido.EMITIDO.equals(this.getStatus());
	}
	
	@Transient
	public boolean isNaoEmissivel() {
		return !this.isEmissivel();
	}
	
	@Transient
	private boolean isEmissivel() {
		return this.isExisten() && this.isOrcamento();
	}
	
	@Transient
	public boolean isNaoCancelavel() {
		return !this.isCancelavel();
	}
	
	@Transient
	private boolean isCancelado() {
		return StatusPedido.CANCELADO.equals(this.getStatus());
	}
	
	@Transient
	public boolean isCancelavel(){
		return this.isExisten() && !this.isCancelado();
	}

}