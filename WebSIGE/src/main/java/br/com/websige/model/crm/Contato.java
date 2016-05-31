package br.com.websige.model.crm;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.websige.pattern.GenericEntity;
import br.com.websige.model.basico.Cliente;
import br.com.websige.model.basico.Email;
import br.com.websige.model.basico.Imagem;
import br.com.websige.model.basico.Telefone;
import br.com.websige.model.basico.endereco.Endereco;

@Entity
@Table(name = "CONTATO_CNT")
public class Contato extends GenericEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "CNT_NMCONTATO", nullable = false, length = 80)
	private String nome;
	
	@Column(name = "CNT_DSCARGO", nullable = true, length = 40)
	private String cargo;
	
	@Column(name = "CNT_DTANIVERSARIO", nullable = true)
	@Temporal(TemporalType.DATE)
	private Date dataAniversario;
	
	@Column(name = "CNT_DSCONTATO")
	private String descricao;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "CNT_IDCLIENTE", nullable = true, foreignKey = @ForeignKey(name = "FK1_CONTATO_CNT"))
	private Cliente cliente;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "CNT_IDENDERECO", nullable = true, foreignKey = @ForeignKey(name = "FK2_CONTATO_CNT"))
	private Endereco endereco;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name = "CNTTEL_CNTE", joinColumns={@JoinColumn(name = "CNTE_IDCONTATO", foreignKey = @ForeignKey(name = "FK1_CNTTEL_CNTE"))}, 
							  inverseJoinColumns={@JoinColumn(name = "CNTE_IDTELEFONE", foreignKey = @ForeignKey(name = "FK2_CNTTEL_CNTE"))})
	private List<Telefone> telefones;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name = "CNTEMA_CNEM", joinColumns={@JoinColumn(name = "CNEM_IDCONTATO", foreignKey = @ForeignKey(name = "FK1_CNTEMA_CNEM"))}, 
							  inverseJoinColumns={@JoinColumn(name = "CNEM_IDEMAIL", foreignKey = @ForeignKey(name = "FK2_CNTEMA_CNEM"))})
	private List<Email> emails;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "CNT_IDREDESOCIAL", nullable = true, foreignKey = @ForeignKey(name = "FK3_CONTATO_CNT"))
	private RedeSocial redeSocial;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "CNT_IDCATEGORIACLIENTE", nullable = true, foreignKey = @ForeignKey(name = "FK4_CONTATO_CNT"))
	private CategoriaCliente categoriaCliente;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "CNT_IDIMAGEM", nullable = true, foreignKey = @ForeignKey(name = "FK5_CONTATO_CNT"))
	private Imagem imagem;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public Date getDataAniversario() {
		return dataAniversario;
	}
	public void setDataAniversario(Date dataAniversario) {
		this.dataAniversario = dataAniversario;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public List<Telefone> getTelefones() {
		return telefones;
	}
	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}
	public List<Email> getEmails() {
		return emails;
	}
	public void setEmails(List<Email> emails) {
		this.emails = emails;
	}
	public RedeSocial getRedeSocial() {
		return redeSocial;
	}
	public void setRedeSocial(RedeSocial redeSocial) {
		this.redeSocial = redeSocial;
	}
	public CategoriaCliente getCategoriaCliente() {
		return categoriaCliente;
	}
	public void setCategoriaCliente(CategoriaCliente categoriaCliente) {
		this.categoriaCliente = categoriaCliente;
	}
	public Imagem getImagem() {
		return imagem;
	}
	public void setImagem(Imagem imagem) {
		this.imagem = imagem;
	}
	
}
