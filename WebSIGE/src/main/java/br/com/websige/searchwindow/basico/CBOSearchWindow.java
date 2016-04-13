package br.com.websige.searchwindow.basico;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.websige.filter.basico.CBOFilter;
import br.com.websige.model.basico.CBO;
import br.com.websige.pattern.GenericSearchWindow;
import br.com.websige.repository.basico.CBORepository;

@Named
@ViewScoped
public class CBOSearchWindow extends GenericSearchWindow<CBO, CBOFilter> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private CBORepository cboRepository;
	
	@Inject
	public CBOSearchWindow(CBORepository repository) {
		super(repository);
		super.setDirectory("/SearchWindow/Basico/CBOSearchWindow");
	}
	
	@Override
	public CBOFilter createFilter() {
		return new CBOFilter();
	}
	
	public List<CBO> complete(String query){
		setFilter(createFilter());
		getFilter().setTituloOcupacao(query);
		return cboRepository.getByFilter(getFilter());
	}
}
