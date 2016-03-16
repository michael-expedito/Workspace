package br.com.websige.repository.basico;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.websige.model.basico.Filial;
import br.com.websige.pattern.GenericRepository;

public class FilialRepository extends GenericRepository<Filial> implements Serializable  {

	private static final long serialVersionUID = 1L;

	@Inject
	public FilialRepository(EntityManager entityManager) {
		super(entityManager);
	}

}
