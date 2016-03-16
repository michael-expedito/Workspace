package br.com.websige.service.basico;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.websige.model.basico.Filial;
import br.com.websige.pattern.GenericService;
import br.com.websige.repository.basico.FilialRepository;

public class FilialService extends GenericService<Filial> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	public FilialService(FilialRepository filialRepository) {
		super.repository = filialRepository;
	}
}
