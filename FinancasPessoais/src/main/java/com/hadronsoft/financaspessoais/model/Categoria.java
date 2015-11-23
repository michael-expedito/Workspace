package com.hadronsoft.financaspessoais.model;

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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "CATEGORIA_CAT")
public class Categoria implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "CAT_ID")
	private Long id;

	@Column(name = "CAT_DSCATEGORIA", nullable = false, length = 60)
	private String descricao;

	@ManyToOne
	@JoinColumn(name = "CAT_IDCATEGORIAPAI", foreignKey = @ForeignKey(name = "FK1_CATEGORIA_CATEGORIA") )
	private Categoria categoriaPai;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "CAT_IDCADASTRO", nullable = false, foreignKey = @ForeignKey(name = "FK2_CATEGORIA_CADASTRO") )
	private Cadastro cadastro;

	@NotNull
	@Column(name = "CAT_NIVEL", nullable = false)
	private int nivel;
	
	@NotNull
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "CAT_TPCATEGORIA", nullable = false)
	private TipoCategoria tipoCategoria;
	
	@NotNull
	@Column(name = "CAT_ORDENACAO",  nullable = false)
	private long ordenacao;

	@OneToMany(mappedBy = "categoriaPai")
	private List<Categoria> subcategorias;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Categoria getCategoriaPai() {
		return categoriaPai;
	}

	public void setCategoriaPai(Categoria categoriaPai) {
		this.categoriaPai = categoriaPai;
	}

	public Cadastro getCadastro() {
		return cadastro;
	}

	public void setCadastro(Cadastro cadastro) {
		this.cadastro = cadastro;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public TipoCategoria getTipoCategoria() {
		return tipoCategoria;
	}

	public void setTipoCategoria(TipoCategoria tipoCategoria) {
		this.tipoCategoria = tipoCategoria;
	}

	public long getOrdenacao() {
		return ordenacao;
	}

	public void setOrdenacao(long ordenacao) {
		this.ordenacao = ordenacao;
	}

	public List<Categoria> getSubcategorias() {
		return subcategorias;
	}

	public void setSubcategorias(List<Categoria> subcategorias) {
		this.subcategorias = subcategorias;
	}

	@Transient
	public String getDescricaoIdentada(){
		return  repeat("-",this.nivel*2) + (this.tipoCategoria == TipoCategoria.SINTETICA ? " (+) ": "-") + this.descricao ;
	}

	@Transient
	public String repeat(String str, int times) {
		StringBuilder ret = new StringBuilder();
		for (int i = 0; i < times; i++)
			ret.append(str);
		return ret.toString();
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
		Categoria other = (Categoria) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}