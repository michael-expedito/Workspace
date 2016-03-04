package br.com.websige.controller.basico;

import java.io.Serializable;
import java.util.List;

import javax.inject.Named;

import br.com.websige.model.basico.Filial;
import br.com.websige.pattern.CadastroBean;

@Named
@javax.faces.view.ViewScoped
public class FilialBean extends CadastroBean<Filial> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Filial filial;
	private List<Filial> filiais;
	
	public Filial getFilial() {
		return filial;
	}
	public void setFilial(Filial filial) {
		this.filial = filial;
	}
	public List<Filial> getFiliais() {
		return filiais;
	}
	public void setFiliais(List<Filial> filiais) {
		this.filiais = filiais;
	}
}
