package br.com.websige.model.basico;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import br.com.websige.model.basico.endereco.Endereco;
import br.com.websige.model.basico.enuns.TipoPessoa;
import br.com.websige.pattern.interfaces.IBaseEntity;

@Entity
@Table(name="FORNECEDOR_FOR")
public class Fornecedor implements IBaseEntity ,Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name = "FOR_ID")
	private Long id;
	
	@NotNull(message = "Código")
	@Column(name = "FOR_CDFORNECEDOR", nullable = false, length = 15)
	private String codigo;
	
	@NotNull(message = "Descrição")
	@Column(name = "FOR_DSFORNECEDOR", nullable = false, length = 40)
	private String descricao;
	
	@NotNull(message = "Tipo de pessoa")
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "FOR_TPPESSOA", nullable = false)
	private TipoPessoa tipoPessoa;
	
	@ManyToOne
	@JoinColumn(name = "FOR_IDPFISICA", nullable = true, foreignKey = @ForeignKey(name = "FK1_FORNECEDOR_FOR"))
	private PessoaFisica pessoaFisica;
	
	@ManyToOne
	@JoinColumn(name = "FOR_IDPJURIDICA", nullable = true, foreignKey = @ForeignKey(name = "FK2_FORNECEDOR_FOR"))
	private PessoaJuridica pessoaJuridica;
	
	@ManyToMany
	@JoinTable(name = "FOREND_FOEN", joinColumns={@JoinColumn(name = "FOEN_IDFORNECEDOR")}, inverseJoinColumns={@JoinColumn(name = "FOEN_IDENDERECO")})
	private List<Endereco> enderecos;
	
	@Column(name = "FOR_NRTELEFONE", nullable = false, length = 14)
	private String telefone;
	
	@Column(name = "FOR_EMAIL", nullable = false, length = 80)
	private String email;		
	
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
		Fornecedor other = (Fornecedor) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	/*FOR_CODIGO, FOR_NOME, FOR_ENDERECO, FOR_TIPESSOA, FOR_BAIRRO, 
	 * FOR_CIDADE, FOR_UF, FOR_CEP, FOR_TEL, FOR_FAX, FOR_CGC, FOR_INSCRICAO, 
	 * FOR_CONTATO, FOR_ENDERECO1, FOR_NOCONTAB, FOR_CDGRUPO, FOR_DTMOV, 
	 * FOR_DTCAD, FOR_DTNASC, FOR_CODBAIRRO, FOR_NOMEFANT, FOR_ATIVO, 
	 * FOR_RESPCAD, FOR_HOMOLOGADO, FOR_RESPHOMOLOG, FOR_DTHOMOLOG, 
	 * FOR_QTDDEP, FOR_PAIS, FOR_INSCINSS, FOR_CLASSEINSS, FOR_TETOMAX, 
	 * FOR_EMAIL, FOR_EXP, FOR_INSCMUNIP, FOR_TPCOBR, FOR_INSCSUFRAMA, 
	 * FOR_SALBASE, FOR_PISPASEP, FOR_CATTRAB, FOR_MOTIVINAT, FOR_DTINATIV, 
	 * FOR_USUARIOMOV, FOR_COOPERATIVA, FOR_SQCBO, FOR_NAC, FOR_ESTADOCIVIL, 
	 * FOR_CBO, FOR_GRPEMPRESARIAL, FOR_NUMENDERECO, FOR_COMPENDERECO, 
	 * FOR_CDPAIS, FOR_VBPRURAL, FOR_TPINDIEDEST */
}
