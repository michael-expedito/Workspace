package br.com.websige.controller.basico;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.websige.pattern.CadastroBean;
import br.com.websige.filter.basico.FornecedorFilter;
import br.com.websige.model.basico.CBO;
import br.com.websige.model.basico.Fornecedor;
import br.com.websige.model.basico.PessoaFisica;
import br.com.websige.model.basico.PessoaJuridica;
import br.com.websige.model.basico.endereco.Endereco;
import br.com.websige.model.basico.enuns.EstadoCivil;
import br.com.websige.model.basico.enuns.TipoPessoa;
import br.com.websige.repository.basico.FornecedorRepository;
import br.com.websige.service.basico.FornecedorService;
import br.com.websige.util.framework.FrameworkFunctions;

@Named
@ViewScoped
public class FornecedorBean extends CadastroBean<Fornecedor, FornecedorFilter> implements Serializable {

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
		return "entity=" + entityConsulted.getId();
	};

	@Override
	public void salvar() {
		if (getEntity().getTipoPessoa() == TipoPessoa.FISICA) {
			getEntity().setPessoaJuridica(null);
		} else {
			getEntity().setPessoaFisica(null);
		}
		super.salvar();
	}
	
	@Override
	public void createSubEntities() {
		if (getEntity().getPessoaJuridica() == null) {
			((Fornecedor) getEntity()).setPessoaJuridica(new PessoaJuridica());
		}
		if (getEntity().getPessoaFisica() == null) {
			((Fornecedor) getEntity()).setPessoaFisica(new PessoaFisica());
		}
		if (getEntity().getEnderecos() == null) {
			((Fornecedor) getEntity()).setEnderecos(new ArrayList<Endereco>());
		}
	}

	// Geters e Seters de Enuns
	public TipoPessoa[] getTipoPessoas() {
		return TipoPessoa.values();
	}

	public EstadoCivil[] getEstadosCivis() {
		return EstadoCivil.values();
	}

	// Métodos específicos da tela de Fornecedor
	public void cboSelecionado(org.primefaces.event.SelectEvent event) {
		CBO cbo = (CBO) event.getObject();
		getEntity().getPessoaFisica().setCbo(cbo);
	}

	public void enderecoRetornado(org.primefaces.event.SelectEvent event) {
		Endereco endereco = (Endereco) event.getObject();
		if (endereco != null) {
			if (!FrameworkFunctions.checkEmpty(endereco)) {
				if (endereco.getId() == null) {
					getEntity().getEnderecos().add(endereco);
				} else {
					getEntity().getEnderecos().set(endereco.getId().intValue(), endereco);
				}
			}
		}
	}

	public void removerEndereco(Endereco endereco) {
		Map<String,String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		String id = params.get("id");
		getEntity().getEnderecos().remove(Integer.parseInt(id));
	}
}
