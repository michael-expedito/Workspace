package com.hadronsoft.websige.models.common;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Mensagem implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private long id;
	private String assunto;
	private String mensagem;
	private String anexos;
	private List<Usuario> destinatarios;
	private Usuario emissor;
	private Date dataEnvio;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getAssunto() {
		return assunto;
	}
	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public String getAnexos() {
		return anexos;
	}
	public void setAnexos(String anexos) {
		this.anexos = anexos;
	}
	public List<Usuario> getDestinatario() {
		return destinatarios;
	}
	public void setDestinatarios(List<Usuario> destinatarios) {
		this.destinatarios = destinatarios;
	}
	public Usuario getEmissor() {
		return emissor;
	}
	public void setEmissor(Usuario emissor) {
		this.emissor = emissor;
	}
	
	
	public Date getDataEnvio() {
		return dataEnvio;
	}
	public void setDataEnvio(Date dataEnvio) {
		this.dataEnvio = dataEnvio;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
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
		Mensagem other = (Mensagem) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	
	
}
