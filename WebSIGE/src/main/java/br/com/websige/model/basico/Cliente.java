package br.com.websige.model.basico;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.websige.model.basico.enuns.TipoPessoa;
import br.com.websige.model.crm.CategoriaCliente;
import br.com.websige.model.crm.RedeSocial;
import br.com.websige.model.basico.endereco.Endereco;
import br.com.websige.pattern.GenericEntity;

@Entity
@Table(name = "CLIENTE_CLI")
public class Cliente extends GenericEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "CLI_CDCLIENTE", nullable = false, length = 15)
	private String codigo;
	
	@Column(name = "CLI_NMCLIENTE", nullable = false, length = 40)
	private String nome;
	
	@Column(name = "CLI_DSFORNECEDOR", nullable = false, length = 255)
	private String descricao;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "CLI_TPPESSOA", nullable = false)
	private TipoPessoa tipoPessoa;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "CLI_IDPFISICA", nullable = true, foreignKey = @ForeignKey(name = "FK1_CLIENTE_CLI"))
	private PessoaFisica pessoaFisica;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "CLI_IDPJURIDICA", nullable = true, foreignKey = @ForeignKey(name = "FK2_CLIENTE_CLI"))
	private PessoaJuridica pessoaJuridica;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name = "CLIEND_CLEN", joinColumns={@JoinColumn(name = "CLEN_IDCLIENTE", foreignKey = @ForeignKey(name = "FK1_CLIEND_CLEN"))}, 
	                          inverseJoinColumns={@JoinColumn(name = "CLEN_IDENDERECO", foreignKey = @ForeignKey(name = "FK2_CLIEND_CLEN"))})
	private List<Endereco> endereco;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name = "CLIEMA_CLEM", joinColumns ={@JoinColumn(name = "CLEM_IDCLIENTE", foreignKey = @ForeignKey(name = "FK1_CLIEND_CLEM") )}, 
	                          inverseJoinColumns ={@JoinColumn(name = "CLEM_IDEMAIL", foreignKey = @ForeignKey(name = "FK2_CLIEND_CLEM"))})
	private List<Email> emails;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name = "CLITEL_CLTE", joinColumns={@JoinColumn(name = "CLTE_IDCLIENTE", foreignKey = @ForeignKey(name = "FK1_CLITEL_CLTE"))}, 
	                          inverseJoinColumns={@JoinColumn(name = "CLTE_IDTELEFONE", foreignKey = @ForeignKey(name = "FK1_CLITEL_CLTE"))})
	private List<Telefone> telefones;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "CLI_IDREDESOCIAL", nullable = true, foreignKey = @ForeignKey(name = "FK3_CLIENTE_CLI"))
	private RedeSocial redeSocial;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "CLI_IDSEGMENTO", nullable = true, foreignKey = @ForeignKey(name = "FK4_CLIENTE_CLI"))
	private Segmento segmento;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "CLI_IDCATEGORIACLIENTE", nullable = true, foreignKey = @ForeignKey(name = "FK5_CLIENTE_CLI"))
	private CategoriaCliente categoriaCliente;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "CLI_IDIMAGEM", nullable = true, foreignKey = @ForeignKey(name = "FK6_CLIENTE_CLI"))
	private Imagem imagem;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public TipoPessoa getTipoPessoa() {
		return tipoPessoa;
	}
	public void setTipoPessoa(TipoPessoa tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}
	public PessoaFisica getPessoaFisica() {
		return pessoaFisica;
	}
	public void setPessoaFisica(PessoaFisica pessoaFisica) {
		this.pessoaFisica = pessoaFisica;
	}
	public PessoaJuridica getPessoaJuridica() {
		return pessoaJuridica;
	}
	public void setPessoaJuridica(PessoaJuridica pessoaJuridica) {
		this.pessoaJuridica = pessoaJuridica;
	}
	public List<Endereco> getEndereco() {
		return endereco;
	}
	public void setEndereco(List<Endereco> endereco) {
		this.endereco = endereco;
	}
	public List<Email> getEmails() {
		return emails;
	}
	public void setEmails(List<Email> emails) {
		this.emails = emails;
	}
	public List<Telefone> getTelefones() {
		return telefones;
	}
	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}
	public RedeSocial getRedeSocial() {
		return redeSocial;
	}
	public void setRedeSocial(RedeSocial redeSocial) {
		this.redeSocial = redeSocial;
	}
	public Segmento getSegmento() {
		return segmento;
	}
	public void setSegmento(Segmento segmento) {
		this.segmento = segmento;
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
		Cliente other = (Cliente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
