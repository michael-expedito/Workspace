package br.com.websige.searchwindow.basico;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.websige.filter.basico.CidadeFilter;
import br.com.websige.model.basico.endereco.Cidade;
import br.com.websige.pattern.GenericSearchWindow;
import br.com.websige.repository.basico.CidadeRepository;

@Named
@ViewScoped
public class CidadeSearchWindow extends GenericSearchWindow<Cidade, CidadeFilter> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	public CidadeSearchWindow(CidadeRepository repository) {
		super(repository);
		super.setDirectory("/SearchWindow/Basico/CidadeSearchWindow");
	}

	@Override
	public List<Cidade> complete(String query) {
		setFilter(createFilter());
		getFilter().setNome(query);
		return super.getRepository().getByFilter(getFilter());	}

	@Override
	public CidadeFilter createFilter() {
		return new CidadeFilter();
	}

	@Override
	public String getParhResource() {
		return "basico.cadastro.cidade.cidade";
	}

	@Override
	public String getColumnTemplate() {
		return "codigo;nome";
	}
}
