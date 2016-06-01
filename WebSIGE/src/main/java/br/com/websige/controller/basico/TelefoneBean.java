package br.com.websige.controller.basico;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import br.com.websige.model.basico.Telefone;

@Named
@SessionScoped
public class TelefoneBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Telefone telefone;
	
	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	public void openWindow(Telefone entity) {
		if (entity == null){
			telefone = new Telefone();
		} else {
			telefone = entity;
		}
		Map<String,String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		String id = params.get("id");
		if (id != null)	{ 
			telefone.setId(new Long(id));
		}
		
		Map<String, Object> opcoes = new HashMap<>();
		opcoes.put("modal", true);
		opcoes.put("resizable", false);
		opcoes.put("contentHeight", 125);
		opcoes.put("contentWidth", 500);
		RequestContext.getCurrentInstance().openDialog("/Restrict/Basico/Cadastro/Telefone/DialogCadastro", opcoes,
				null);
	}
	
	public void confirmar(){
		RequestContext.getCurrentInstance().closeDialog(telefone);
	}
}
