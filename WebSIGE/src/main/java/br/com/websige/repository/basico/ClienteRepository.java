package br.com.websige.repository.basico;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.websige.model.basico.Cliente;
import br.com.websige.pattern.GenericRepository;

public class ClienteRepository extends GenericRepository<Cliente>{

	private static final long serialVersionUID = 1L;
	
	@Inject
	public ClienteRepository(EntityManager entityManager) {
		super(entityManager);
	}

	
	
	

}
