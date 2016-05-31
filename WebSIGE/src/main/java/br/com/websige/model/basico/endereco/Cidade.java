package br.com.websige.model.basico.endereco;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.websige.pattern.GenericEntity;
import br.com.websige.pattern.annotations.ResourceEntity;

@Entity
@Table(name="CIDADE_CID")
@ResourceEntity(resourceDirectory="basico.cadastro.cidade.cidade")
public class Cidade extends GenericEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "CID_CDCIDADE", nullable = false, length = 7)
	private String codigo;
	
	@Column(name = "CID_NMCIDADE", nullable = false, length = 35)
	private String nome;
	
	@Column(name = "CID_CDSIAFI", nullable = true, length = 6)
	private String codigoSiafi;
	
	@Column(name = "CID_CDDIEF", nullable = true, length = 6)
	private String codigoDief;
	
	@Column(name = "CID_CDGIASP", nullable = true, length = 6)
	private String codigoGiasp;
	
	@ManyToOne
	@JoinColumn(name = "CID_CDESTADOUF", nullable = false, foreignKey = @ForeignKey(name = "FK1_CIDADE_CID"))
	private UF estado;

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
}
