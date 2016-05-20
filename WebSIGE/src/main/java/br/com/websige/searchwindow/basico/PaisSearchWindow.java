package br.com.websige.searchwindow.basico;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.websige.filter.basico.PaisFilter;
import br.com.websige.model.basico.endereco.Pais;
import br.com.websige.pattern.GenericSearchWindow;
import br.com.websige.repository.basico.PaisRepository;

@Named
@ViewScoped
public class PaisSearchWindow  extends GenericSearchWindow<Pais, PaisFilter> implements Serializable {

	@Inject
	public PaisSearchWindow(PaisRepository repository) {
		super(repository);
	}

	private static final long serialVersionUID = 1L;

	@Override
	public List<Pais> complete(String query) {
		setFilter(createFilter());
		getFilter().setNome(query);
		return getRepository().getByFilter(getFilter());
	}

	@Override
	public PaisFilter createFilter() {
		return new PaisFilter();
	}

	@Override
	public String getParhResource() {
		return "basico.cadastro.pais.pais";
	}

	@Override
	public String getColumnTemplate() {
		return "codigo;nome";
	}

}
