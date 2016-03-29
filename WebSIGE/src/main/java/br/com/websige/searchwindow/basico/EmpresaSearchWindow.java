package br.com.websige.searchwindow.basico;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.websige.filter.basico.EmpresaFilter;
import br.com.websige.model.basico.Empresa;
import br.com.websige.pattern.GenericSearchWindow;
import br.com.websige.repository.basico.EmpresaRepository;

@Named
@ViewScoped
public class EmpresaSearchWindow extends GenericSearchWindow<Empresa, EmpresaFilter> implements Serializable {

	@Inject
	public EmpresaSearchWindow(EmpresaRepository repository) {
		super(repository);
		super.setDirectory("/SearchWindow/Basico/EmpresaSearchWindow");
		getFiltros().add("Codigo");
		getFiltros().add("CNPJ");
		getFiltros().add("Nome");
	}

	private static final long serialVersionUID = 1L;
	
	@Override
	public void setParameterInFilter(){
		if (getFiltro().equals("Codigo")){
			getFilter().setCodigo(getValor());
		}
		if (getFiltro().equals("CNPJ")){
			getFilter().setCNPJ(getValor());
		}
		if (getFiltro().equals("Nome")){
			getFilter().setNome(getValor());
		}
	}

	@Override
	public EmpresaFilter createFilter() {
		return new EmpresaFilter();
	}
}
