package br.com.websige.controller.basico;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import br.com.websige.model.basico.endereco.Cidade;
import br.com.websige.model.basico.endereco.Endereco;
import br.com.websige.model.basico.endereco.Pais;
import br.com.websige.model.basico.endereco.UF;
import br.com.websige.repository.basico.PaisRepository;
import br.com.websige.repository.basico.UFRepository;

@Named
@SessionScoped
public class EnderecoBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private Endereco endereco;
	
	@Inject
	private UFRepository ufReposutory;
	
	@Inject
	private PaisRepository paisRepository;

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public void openWindow(Endereco entity) {
		if (entity == null){
			endereco = new Endereco();
		} else {
			endereco = entity;
		}
		Map<String,String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		String id = params.get("id");
		if (id != null)	{ 
			endereco.setId(new Long(id));
		}
		
		Map<String, Object> opcoes = new HashMap<>();
		opcoes.put("modal", true);
		opcoes.put("resizable", false);
		opcoes.put("contentHeight", 450);
		opcoes.put("contentWidth", 900);
		RequestContext.getCurrentInstance().openDialog("/Restrict/Basico/Cadastro/Endereco/DialogCadastro", opcoes,
				null);
	}

	public void cidadeSelecionada(org.primefaces.event.SelectEvent event) {
		Cidade cidade = (Cidade) event.getObject();
		endereco.setCidade(cidade);
	}
	
	public void confirmar(){
		RequestContext.getCurrentInstance().closeDialog(endereco);
	}
	
	public List<UF> getUFs(){
		return ufReposutory.getAll();
	}
	
	public List<Pais> getPaises(){
		return paisRepository.getAll();
	}
}
