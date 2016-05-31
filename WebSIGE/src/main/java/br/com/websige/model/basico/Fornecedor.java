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

import br.com.websige.model.basico.endereco.Endereco;
import br.com.websige.model.basico.enuns.TipoPessoa;
import br.com.websige.pattern.GenericEntity;
import br.com.websige.pattern.annotations.ResourceEntity;

@Entity
@Table(name="FORNECEDOR_FOR")
@ResourceEntity(resourceDirectory="basico.cadastro.fornecedor.fornecedor")
public class Fornecedor extends GenericEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "FOR_CDFORNECEDOR", nullable = false, length = 15)
	private String codigo;
	
	@Column(name = "FOR_DSFORNECEDOR", nullable = false, length = 40)
	private String descricao;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "FOR_TPPESSOA", nullable = false)
	private TipoPessoa tipoPessoa;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "FOR_IDPFISICA", nullable = true, foreignKey = @ForeignKey(name = "FK1_FORNECEDOR_FOR"))
	private PessoaFisica pessoaFisica;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "FOR_IDPJURIDICA", nullable = true, foreignKey = @ForeignKey(name = "FK2_FORNECEDOR_FOR"))
	private PessoaJuridica pessoaJuridica;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name = "FOREND_FOEN", foreignKey= @ForeignKey(name = "FK3_FOREND_FOEN"), joinColumns={@JoinColumn(name = "FOEN_IDFORNECEDOR", foreignKey = @ForeignKey(name = "FK1_FOREND_FOEN"))}, 
	                          inverseJoinColumns={@JoinColumn(name = "FOEN_IDENDERECO", foreignKey = @ForeignKey(name = "FK2_FOREND_FOEN"))})
	private List<Endereco> enderecos;
	
	@Column(name = "FOR_NRTELEFONE", nullable = false, length = 14)
	private String telefone;
	
	@Column(name = "FOR_EMAIL", nullable = false, length = 80)
	private String email;		
	

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
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

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
}
