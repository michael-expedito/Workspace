package br.com.websige.controller.basico;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.websige.pattern.CadastroBean;
import br.com.websige.filter.basico.FornecedorFilter;
import br.com.websige.model.basico.Fornecedor;
import br.com.websige.model.basico.enuns.TipoPessoa;
import br.com.websige.repository.basico.FornecedorRepository;
import br.com.websige.service.basico.FornecedorService;

@Named
@javax.faces.view.ViewScoped
public class FornecedorBean extends CadastroBean<Fornecedor, FornecedorFilter>implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	public FornecedorBean(FornecedorRepository repository, FornecedorService service) {
		super(repository, service);
		setDirectory("/Restrict/Basico/Cadastro/Fornecedor/");
	}

	public Fornecedor getFornecedor() {
		return (Fornecedor) getEntity();
	}

	public void setFornecedor(Fornecedor fornecedor) {
		setEntity(fornecedor);
	}

	public List<Fornecedor> getFornecedores() {
		return getListEntity();
	}

	public void setFornecedores(List<Fornecedor> fornecedores) {
		setListEntity(fornecedores);
	}

	public FornecedorFilter getFornecedorFilter() {
		return getFilter();
	}

	public void setFornecedorFilter(FornecedorFilter filter) {
		setFilter(filter);
	}

	@Override
	public Fornecedor createEntity() {
		return new Fornecedor();
	}

	@Override
	public FornecedorFilter createFilter() {
		return new FornecedorFilter();
	}

	@Override
	protected String getParameterURL(Fornecedor entityConsulted) {
		return "fornecedor=" + entityConsulted.getId();
	};
	
	public TipoPessoa[] getTipoPessoas() {
		return TipoPessoa.values();
	}
	/*
	public void empresaSelecionada(SelectEvent event) {
		Empresa empresa = (Empresa) event.getObject();
		getEntity().setEmpresa(empresa);
	}

	public List<Empresa> getEmpresaListFilter() {
		return empresaRepository.getAll();
	}
	*/
}
