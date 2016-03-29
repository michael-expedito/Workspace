package br.com.websige.repository.basico;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.websige.filter.basico.FilialFilter;
import br.com.websige.model.basico.Filial;
import br.com.websige.pattern.GenericFilter;
import br.com.websige.pattern.GenericRepository;

public class FilialRepository extends GenericRepository<Filial> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	public FilialRepository(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<Filial> getByFilter(GenericFilter<Filial> filter) {
		if (filter != null && ((FilialFilter) filter).getEmpresa() != null) {
			return super.entityManager.createQuery("FROM Filial WHERE filial = :filial", Filial.class)
					.setParameter("filial", ((FilialFilter) filter).getEmpresa()).getResultList();
		} else {
			return super.getByFilter(filter);
		}
	}

}
