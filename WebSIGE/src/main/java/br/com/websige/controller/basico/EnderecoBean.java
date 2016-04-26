package br.com.websige.controller.basico;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import br.com.websige.model.basico.endereco.Cidade;
import br.com.websige.model.basico.endereco.Endereco;

@Named
@ViewScoped
public class EnderecoBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private Endereco endereco;

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public void openWindow() {
		Map<String, Object> opcoes = new HashMap<>();
		opcoes.put("modal", true);
		opcoes.put("resizable", false);
		RequestContext.getCurrentInstance().openDialog("/Restrict/Basico/Cadastro/Endereco/DialogCadastro" , opcoes, null);
		
	}
	
	public void cidadeSelecionada(org.primefaces.event.SelectEvent event) {
		Cidade cidade = (Cidade) event.getObject();
		endereco.setCidade(cidade);
	}
}
