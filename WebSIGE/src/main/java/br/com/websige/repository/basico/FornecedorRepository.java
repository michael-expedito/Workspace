package br.com.websige.repository.basico;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.websige.model.basico.Fornecedor;
import br.com.websige.pattern.GenericRepository;

public class FornecedorRepository extends GenericRepository<Fornecedor> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	public FornecedorRepository(EntityManager entityManager) {
		super(entityManager);
	}
}
