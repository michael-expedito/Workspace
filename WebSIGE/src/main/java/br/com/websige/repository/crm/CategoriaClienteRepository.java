package br.com.websige.repository.crm;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.websige.model.crm.CategoriaCliente;
import br.com.websige.pattern.GenericRepository;

public class CategoriaClienteRepository extends GenericRepository<CategoriaCliente>{

	private static final long serialVersionUID = 1L;
	
	@Inject
	public CategoriaClienteRepository(EntityManager entityManager) {
		super(entityManager);
	}

}
