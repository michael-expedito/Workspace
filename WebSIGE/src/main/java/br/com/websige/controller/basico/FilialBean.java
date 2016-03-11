package br.com.websige.controller.basico;

import java.io.Serializable;
import java.util.List;

import javax.inject.Named;

import br.com.websige.filter.basico.FilialFilter;
import br.com.websige.model.basico.Filial;
import br.com.websige.pattern.CadastroBean;
import br.com.websige.pattern.GenericRepository;
import br.com.websige.pattern.GenericService;

@Named
@javax.faces.view.ViewScoped
public class FilialBean extends CadastroBean<Filial, FilialFilter> implements Serializable {

	public FilialBean(GenericRepository<Filial> repository, GenericService<Filial> service) {
		super(repository, service);
		
	}
	
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
