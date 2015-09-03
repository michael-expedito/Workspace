package com.hadronsoft.websige.controllers.common;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.hadronsoft.websige.models.common.Mensagem;
import com.hadronsoft.websige.models.common.Notificacao;
import com.hadronsoft.websige.models.common.Usuario;

@Named
@SessionScoped
public class MainBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private List<Mensagem> mensagens;
	
	public MainBean() {
		Mensagem msg = new Mensagem();
		msg.setAssunto("Ja comprou um novo Template?");
		msg.setDestinatario("Michael Expedito");
		msg.setEmissor("Aline Dias");
		msg.setDataEnvio(new Date(System.currentTimeMillis()));
		
		mensagens.add(msg);
		
		msg = new Mensagem();
		msg.setAssunto("Termina logo esse sistema!");
		msg.setDestinatario("Michael Expedito");
		msg.setEmissor("Ronan Araujo");
		msg.setDataEnvio(new Date(System.currentTimeMillis()));
		
		mensagens.add(msg);
	}

	public List<Mensagem> getMensagens() {
		return mensagens;
	}

	public void setMensagens(List<Mensagem> mensagens) {
		this.mensagens = mensagens;
	}

	public List<Notificacao> getNotificacoes() {
		return notificacoes;
	}

	public void setNotificacoes(List<Notificacao> notificacoes) {
		this.notificacoes = notificacoes;
	}
	
	
	
	
}
