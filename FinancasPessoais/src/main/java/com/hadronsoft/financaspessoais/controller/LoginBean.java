package com.hadronsoft.financaspessoais.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.hadronsoft.financaspessoais.model.Cadastro;
import com.hadronsoft.financaspessoais.security.SessionContext;
import com.hadronsoft.financaspessoais.service.CadastroService;
import com.hadronsoft.financaspessoais.util.FacesUtil;

@Named
@SessionScoped
public class LoginBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	CadastroService cadastroService;
	
	private String email;
	private String senha;
	
	public Cadastro getCadastro(){
		return (Cadastro) SessionContext.getInstance().getUsuarioLogado();
	}
	
	public String fazerLogin(){
		try {
			Cadastro cadastro = cadastroService.isCadastroReadyToLogin(email, senha);
			if (cadastro == null) {
				FacesUtil.addErrorMessage("Login ou Senha errado, tente novamente !");
				return "";
			}
			SessionContext.getInstance().setAttribute("usuarioLogado", cadastro);
			return "/Home.xhtml?faces-redirect=true";
			
		} catch (Exception e) {
			FacesUtil.addErrorMessage(e.getMessage());
			return "";
		}
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

}
