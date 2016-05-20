package br.com.websige.searchwindow.basico;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.websige.filter.basico.UFFilter;
import br.com.websige.model.basico.endereco.UF;
import br.com.websige.repository.basico.UFRepository;
import br.com.websige.pattern.GenericSearchWindow;

@Named
@ViewScoped
public class UFSearchWindow extends GenericSearchWindow<UF, UFFilter> implements Serializable {

	public UFSearchWindow(UFRepository repository) {
		super(repository);
		super.pesquisar();
		// TODO IMPLEMENTAR SET DIRECTORY
	}

	private static final long serialVersionUID = 1L;

	@Override
	public List<UF> complete(String query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UFFilter createFilter() {
		return new UFFilter();
	}

	@Override
	public String getParhResource() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getColumnTemplate() {
		// TODO Auto-generated method stub
		return null;
	}
}
