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
import br.com.websige.util.FacesUtil;

@Named
@javax.faces.view.ViewScoped
public class EmpresaBean extends CadastroBean<Empresa> implements Serializable {

	private static final long serialVersionUID = 1L;

	private Empresa empresa;
	private List<Empresa> empresas;
	private EmpresaFilter filter;

	@Inject
	private EmpresaService empresaService;

	@Inject
	private EmpresaRepository empresaRepository;

	@Override
	public void startCadastro() {
		if (empresa == null) {
			empresa = new Empresa();
		}
	}

	public String consultarEntidade(Empresa emp) {
		return "/Restrict/Basico/Cadastro/Empresa/Cadastro?faces-redirect=true&empresa=" + emp.getId();
	}

	public String novo() {
		return "/Restrict/Basico/Cadastro/Empresa/Cadastro?faces-redirect=true";
	}

	public void startConsulta() {
		if (filter == null) {
			filter = new EmpresaFilter();
		}
		empresas = empresaRepository.findAll();
	}

	public void salvar() {
		empresaService.process(empresa);
		FacesUtil.addListMessageService(empresaService.messages);
	}

	public void excluir() {
		empresaService.revertProcess(empresa);
		FacesUtil.addListMessageService(empresaService.messages);
	}
	
	public void consultar(){
		empresas = empresaRepository.getByFilter(filter);
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public List<Empresa> getEmpresas() {
		return empresas;
	}

	public void setEmpresas(List<Empresa> empresas) {
		this.empresas = empresas;
	}

	public EmpresaFilter getFilter() {
		return filter;
	}

	public void setFilter(EmpresaFilter filter) {
		this.filter = filter;
	}
}
