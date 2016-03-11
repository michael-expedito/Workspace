package br.com.websige.controller.basico;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.websige.pattern.CadastroBean;
import br.com.websige.filter.basico.EmpresaFilter;
import br.com.websige.model.basico.Empresa;
import br.com.websige.repository.basico.EmpresaRepository;
import br.com.websige.service.basico.EmpresaService;

@Named
@javax.faces.view.ViewScoped
public class EmpresaBean extends CadastroBean<Empresa, EmpresaFilter> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	public EmpresaBean(EmpresaRepository repository, EmpresaService service) {
		super(repository, service);
		setDirectory("/Restrict/Basico/Cadastro/Empresa/");
	}
	
	public Empresa getEmpresa() {
		return (Empresa)getEntity();
	}

	public void setEmpresa(Empresa empresa) {
		setEntity(empresa);
	}

	public EmpresaFilter getEmpresaFilter() {
		return getFilter();
	}

	public void setEmpresaFilter(EmpresaFilter filter) {
		setFilter(filter);
	}
	
	public List<Empresa> getEmpresas() {
		return getListEntity();
	}

	public void setEmpresas(List<Empresa> empresas) {
		setListEntity(empresas);
	}
	
	@Override
	public Empresa createEntity(){
		return new Empresa();
	}
	
	@Override
	public EmpresaFilter createFilter(){
		return new EmpresaFilter();
	}
	
	@Override
	protected String getParameterURL(Empresa entityConsulted) {
		return "empresa=" + entityConsulted.getId();
	};
}
