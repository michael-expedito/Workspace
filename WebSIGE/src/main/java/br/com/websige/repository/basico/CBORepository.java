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

import br.com.websige.filter.basico.CBOFilter;
import br.com.websige.model.basico.CBO;
import br.com.websige.pattern.GenericFilter;
import br.com.websige.pattern.GenericRepository;

public class CBORepository extends GenericRepository<CBO> implements Serializable  {
	
	private static final long serialVersionUID = 1L;

	@Inject
	public CBORepository(EntityManager entityManager) {
		super(entityManager);
	}	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<CBO> getByFilter(GenericFilter<CBO> filter){
		CBOFilter cboFilter = (CBOFilter) filter;
		Session session = this.entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(CBO.class);
		
		if (cboFilter.getCodigoOcupacao() != null && !"".equals(cboFilter.getCodigoOcupacao())) {
			criteria.add(Restrictions.eq("codigoOcupacao", ((CBOFilter) filter).getCodigoOcupacao()));
		}
		
		if (cboFilter.getTituloOcupacao() != null && !"".equals(cboFilter.getTituloOcupacao())){
			criteria.add(Restrictions.ilike("tituloOcupacao", cboFilter.getTituloOcupacao(),MatchMode.ANYWHERE));
		}
		
		return criteria.addOrder(Order.asc("codigoOcupacao")).list();
	}
}
