package br.com.websige.repository.basico;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.websige.model.basico.Segmento;
import br.com.websige.pattern.GenericRepository;

public class SegmentoRepository extends GenericRepository<Segmento>{

	private static final long serialVersionUID = 1L;
	
	@Inject
	public SegmentoRepository(EntityManager entityManager) {
		super(entityManager);
	}
}
