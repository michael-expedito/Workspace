package br.com.websige.service.basico;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.websige.model.basico.Fornecedor;
import br.com.websige.pattern.GenericService;
import br.com.websige.repository.basico.FornecedorRepository;

public class FornecedorService  extends GenericService<Fornecedor> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	public FornecedorService(FornecedorRepository fornecedorRepository) {
		super.repository = fornecedorRepository;
	}

}
