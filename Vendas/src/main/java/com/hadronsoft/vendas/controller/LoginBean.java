package com.hadronsoft.vendas.controller;

import java.io.IOException;
import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hadronsoft.vendas.util.jsf.FacesUtil;

@Named
@SessionScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1L;

    @Inject
	private FacesContext facesContext;
	
	@Inject
	private HttpServletResponse response;
	
	private String email;

	public void preRender() {
		if ("true".equals( 
				((HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest()).getParameter("invalid"))) {
			FacesUtil.addErrorMessage("Usuário ou senha inválido!");
		}
	}
	
	public void login() throws ServletException, IOException {
		RequestDispatcher dispatcher = ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getRequestDispatcher("/j_spring_security_check");
		
		dispatcher.forward( (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest(), response);
		
		facesContext.responseComplete();
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
