package br.com.websige.controller.basico;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import br.com.websige.model.basico.Email;

@Named
@SessionScoped
public class EmailBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Email email;
	
	public Email getEmail() {
		return email;
	}

	public void setEmail(Email email) {
		this.email = email;
	}

	public void openWindow(Email entity) {
		if (entity == null){
			email = new Email();
		} else {
			email = entity;
		}
		Map<String,String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		String id = params.get("id");
		if (id != null)	{ 
			email.setId(new Long(id));
		}
		
		Map<String, Object> opcoes = new HashMap<>();
		opcoes.put("modal", true);
		opcoes.put("resizable", false);
		opcoes.put("contentHeight", 125);
		opcoes.put("contentWidth", 700);
		RequestContext.getCurrentInstance().openDialog("/Restrict/Basico/Cadastro/Email/DialogCadastro", opcoes,
				null);
	}
	
	public void confirmar(){
		RequestContext.getCurrentInstance().closeDialog(email);
	}

}
