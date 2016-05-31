package br.com.websige.model.basico;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

import br.com.websige.pattern.GenericEntity;

@Entity
@Table(name = "IMAGEM_IMG")
public class Imagem extends GenericEntity implements Serializable {

	private static final long serialVersionUID = 1L;
    
    @Lob
    @Column(name = "IMG_IMAGEM", columnDefinition = "LONGBLOB")
    private byte[] imagem;
    
    @Column(name = "IMG_NMIMAGEM", length = 255)
    private String nome;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public byte[] getImagem() {
		return imagem;
	}

	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
