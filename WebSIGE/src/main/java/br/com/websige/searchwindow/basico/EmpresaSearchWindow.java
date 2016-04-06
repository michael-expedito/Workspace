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

	private static final long serialVersionUID = 1L;
	
	@Inject
	public EmpresaSearchWindow(EmpresaRepository repository) {
		super(repository);
		super.setDirectory("/SearchWindow/Basico/EmpresaSearchWindow");
	}
	
	@Override
	public EmpresaFilter createFilter() {
		return new EmpresaFilter();
	}
}
