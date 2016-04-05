package br.com.websige.repository.basico;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

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

	@SuppressWarnings("unchecked")
	@Override
	public List<Filial> getByFilter(GenericFilter<Filial> filter) {

		FilialFilter filialFilter = (FilialFilter) filter;
		Session session = this.entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(Filial.class);

		if (((FilialFilter) filter).getEmpresa() != null) {
			criteria.add(Restrictions.eq("empresa", ((FilialFilter) filter).getEmpresa()));
		}

		if (filialFilter.getCodigo() != null && !"".equals(filialFilter.getCodigo())) {
			criteria.add(Restrictions.eq("codigo", ((FilialFilter) filter).getCodigo()));
		}

		if (filialFilter.getCnpj() != null && !"".equals(filialFilter.getCnpj())) {
			criteria.add(Restrictions.eq("cnpj", ((FilialFilter) filter).getCnpj()));
		}

		if (filialFilter.getDescricao() != null && !"".equals(filialFilter.getDescricao())) {
			criteria.add(Restrictions.ilike("descricao", filialFilter.getDescricao(), MatchMode.ANYWHERE));
		}

		return criteria.addOrder(Order.asc("codigo")).list();

	}

}
