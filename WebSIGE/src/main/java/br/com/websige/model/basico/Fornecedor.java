package br.com.websige.model.basico;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
	
	@Column(name = "FOR_NMFORNECEDOR", nullable = false, length = 40)
	private String nome;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "FOR_TPPESSOA", nullable = false)
	private TipoPessoa tipoPessoa;
	
	@ManyToOne
	@JoinColumn(name = "FOR_IDENDERECO", nullable = false, foreignKey = @ForeignKey(name = "FK1_FORNECEDOR_FOR"))
	private Endereco endereco;
	
	@Column(name = "FOR_NRTELEFONE", nullable = false, length = 14)
	private String telefone;
	
	@Column(name = "FOR_EMAIL", nullable = false, length = 80)
	private String email;
	
	@Column(name = "FOR_NRCNPJCPF", nullable = false, length = 15)
	private String cnpjcpf;
	
	@Column(name = "FOR_NRIE", nullable = false, length = 18)
	private String inscricaoEstadual;
	
	@Column(name = "FOR_NRIM", nullable = false, length = 18)
	private String inscricaoMunicipal;		
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public TipoPessoa getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(TipoPessoa tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
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

	public String getCnpjcpf() {
		return cnpjcpf;
	}

	public void setCnpjcpf(String cnpjcpf) {
		this.cnpjcpf = cnpjcpf;
	}

	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}

	public String getInscricaoMunicipal() {
		return inscricaoMunicipal;
	}

	public void setInscricaoMunicipal(String inscricaoMunicipal) {
		this.inscricaoMunicipal = inscricaoMunicipal;
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
