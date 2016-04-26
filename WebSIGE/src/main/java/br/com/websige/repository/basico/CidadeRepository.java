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

import br.com.websige.filter.basico.CidadeFilter;
import br.com.websige.model.basico.endereco.Cidade;
import br.com.websige.pattern.GenericFilter;
import br.com.websige.pattern.GenericRepository;

public class CidadeRepository extends GenericRepository<Cidade> implements Serializable  {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	public CidadeRepository(EntityManager entityManager) {
		super(entityManager);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cidade> getByFilter(GenericFilter<Cidade> filter) {
		CidadeFilter cidadeFilter = (CidadeFilter) filter;
		Session session = this.entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(Cidade.class);
		
		if (cidadeFilter.getCodigo() != null && !"".equals(cidadeFilter.getCodigo())) {
			criteria.add(Restrictions.eq("codigo", ((CidadeFilter) filter).getCodigo()));
		}
		
		if (cidadeFilter.getNome() != null && !"".equals(cidadeFilter.getNome())){
			criteria.add(Restrictions.ilike("nome", cidadeFilter.getNome(),MatchMode.ANYWHERE));
		}
		
		return criteria.addOrder(Order.asc("codigo")).list();
	}

	
}
