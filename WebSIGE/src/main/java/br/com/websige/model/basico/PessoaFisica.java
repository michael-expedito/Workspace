package br.com.websige.model.basico;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.websige.model.basico.endereco.Pais;
import br.com.websige.model.basico.enuns.EstadoCivil;
import br.com.websige.pattern.GenericEntity;
import br.com.websige.pattern.annotations.ResourceEntity;

@Entity
@Table(name="PESFISICA_PF")
@ResourceEntity(resourceDirectory="basico.cadastro.pessoafisica.pessoafisica")
public class PessoaFisica extends GenericEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "PF_DCCPF", nullable = false, length = 11)
	private String cpf;
	
	@Column(name = "PF_NMFISICO", nullable = false, length = 40)
	private String nome;
	
	@Column(name = "PF_DCIDENTIFICACAO", nullable = true, length = 15)
	private String identificacao;
	
	@Column(name = "PF_DCORGAOEMISSOR", nullable = true, length = 10)
	private String orgaoEmissor;
	
	@Column(name = "PF_DTEMISSAO", nullable = true)
	@Temporal(TemporalType.DATE)
	private Date dataEmissao;
	
	@Column(name = "PF_DCPISPASEB", nullable = true, length = 15)
	private String pis;
	
	@Column(name = "PF_DTNASCIMENTO", nullable = true)
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;
	
	@Column(name = "PF_CDESTADOCIVIL", nullable = true)
	@Enumerated(EnumType.ORDINAL)
	private EstadoCivil estadoCivil;
	
	@Column(name = "PF_DCINSCRICAOINSS", nullable = true, length = 15)
	private String matriculaInss;
	
	@Column(name = "PF_VLSALARIOCONTRIBUICAO", nullable = true, precision = 10, scale = 2)
	private BigDecimal salarioContribuicao;
	
	@Column(name = "PF_NRDEPENDENTES", nullable = true)
	private int dependentes;
	
	@Column(name = "PF_VBTETOMAXIMO", nullable = true)
	private boolean tetoMaximo;
	
	@ManyToOne
	@JoinColumn(name = "PF_IDCBO", nullable = true, foreignKey = @ForeignKey(name = "FK1_PESFISICA_PF") )
	private CBO cbo;
	
	@ManyToOne
	@JoinColumn(name = "PF_IDPAISNACIONALIDADE", nullable = true, foreignKey = @ForeignKey(name = "FK2_PESFISICA_PF") )
	private Pais nacionalidade;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIdentificacao() {
		return identificacao;
	}

	public void setIdentificacao(String identificacao) {
		this.identificacao = identificacao;
	}

	public String getOrgaoEmissor() {
		return orgaoEmissor;
	}

	public void setOrgaoEmissor(String orgaoEmissor) {
		this.orgaoEmissor = orgaoEmissor;
	}

	public Date getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(Date dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public String getPis() {
		return pis;
	}

	public void setPis(String pis) {
		this.pis = pis;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getMatriculaInss() {
		return matriculaInss;
	}

	public void setMatriculaInss(String matriculaInss) {
		this.matriculaInss = matriculaInss;
	}

	public BigDecimal getSalarioContribuicao() {
		return salarioContribuicao;
	}

	public void setSalarioContribuicao(BigDecimal salarioContribuicao) {
		this.salarioContribuicao = salarioContribuicao;
	}

	public int getDependentes() {
		return dependentes;
	}

	public void setDependentes(int dependentes) {
		this.dependentes = dependentes;
	}

	public boolean isTetoMaximo() {
		return tetoMaximo;
	}

	public void setTetoMaximo(boolean tetoMaximo) {
		this.tetoMaximo = tetoMaximo;
	}

	public CBO getCbo() {
		return cbo;
	}

	public void setCbo(CBO cbo) {
		this.cbo = cbo;
	}

	public Pais getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(Pais nacionalidade) {
		this.nacionalidade = nacionalidade;
	}
}
