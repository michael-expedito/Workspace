package br.com.websige.controller.basico;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import br.com.websige.filter.basico.FilialFilter;
import br.com.websige.model.basico.Empresa;
import br.com.websige.model.basico.Filial;
import br.com.websige.pattern.CadastroBean;
import br.com.websige.repository.basico.EmpresaRepository;
import br.com.websige.repository.basico.FilialRepository;
import br.com.websige.service.basico.FilialService;

@Named
@javax.faces.view.ViewScoped
public class FilialBean extends CadastroBean<Filial, FilialFilter>implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	public FilialBean(FilialRepository repository, FilialService service) {
		super(repository, service);
		setDirectory("/Restrict/Basico/Cadastro/Filial/");
	}
	
	@Inject
	private EmpresaRepository empresaRepository;
	
	private List<Empresa> empresaListFilter;

	public Filial getFilial() {
		return (Filial) getEntity();
	}

	public void setFilial(Filial filial) {
		setEntity(filial);
	}

	public List<Filial> getFiliais() {
		return getListEntity();
	}

	public void setFiliais(List<Filial> filiais) {
		setListEntity(filiais);
	}

	public FilialFilter getFilialFilter() {
		return getFilter();
	}

	public void setFilialFilter(FilialFilter filter) {
		setFilter(filter);
	}

	@Override
	public Filial createEntity() {
		return new Filial();
	}

	@Override
	public FilialFilter createFilter() {
		return new FilialFilter();
	}

	@Override
	protected String getParameterURL(Filial entityConsulted) {
		return "filial=" + entityConsulted.getId();
	};
	
	@Override
	public void loadEntitiesFilters() {
		
	}

	public void empresaSelecionada(SelectEvent event) {
		Empresa empresa = (Empresa) event.getObject();
		getEntity().setEmpresa(empresa);
	}

	public List<Empresa> getEmpresaListFilter() {
		return empresaListFilter;
	}
	
}
