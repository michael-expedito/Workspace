package br.com.websige.repository.basico;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.websige.model.basico.Empresa;
import br.com.websige.repository.pattern.GenericRepository;

public class EmpresaRepository extends GenericRepository<Long, Empresa> implements Serializable  {
	
	private static final long serialVersionUID = 1L;

	@Inject
	public EmpresaRepository(EntityManager entityManager) {
		super(entityManager);
	}	
}
