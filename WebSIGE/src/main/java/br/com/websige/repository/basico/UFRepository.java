package br.com.websige.repository.basico;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.websige.model.basico.endereco.UF;
import br.com.websige.pattern.GenericRepository;

public class UFRepository extends GenericRepository<UF> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	public UFRepository(EntityManager entityManager) {
		super(entityManager);
	}
	
	public UF getByCodigo(String codigo){
		return this.entityManager.createQuery("from UF where upper(codigo) = :codigo", UF.class)
				.setParameter("codigo", codigo)
				.getSingleResult();
	}
}
