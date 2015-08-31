package com.hadronsoft.vendas.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "USUARIO_USU")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name="USU_ID", nullable = false, length = 80)
	private Long id;
	
	@Column(name="USU_NMUSUARIO", nullable = false, length = 80)
	private String nome;
	
	@Column(name="USU_EMAIL", nullable = false, unique = true, length = 255)
	private String email;
	
	@Column(name="USU_SENHA", nullable = false, length = 20)
	private String senha;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "USUARIO_GRUPO", joinColumns = @JoinColumn(name="ID_USUARIO", referencedColumnName="USU_ID", foreignKey = @ForeignKey(name="FK1_USUARIO_GRUPO")),
			inverseJoinColumns = @JoinColumn(name = "ID_GRUPO", referencedColumnName="GRP_ID", foreignKey = @ForeignKey(name="FK2_GRUPO_USUARIO")) )
	private List<Grupo> grupos = new ArrayList<>();
	
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
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	

	public List<Grupo> getGrupos() {
		return grupos;
	}
	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
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
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}