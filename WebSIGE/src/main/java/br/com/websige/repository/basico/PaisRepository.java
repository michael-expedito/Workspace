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

import br.com.websige.filter.basico.PaisFilter;
import br.com.websige.model.basico.endereco.Pais;
import br.com.websige.pattern.GenericFilter;
import br.com.websige.pattern.GenericRepository;

public class PaisRepository extends GenericRepository<Pais> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	public PaisRepository(EntityManager entityManager) {
		super(entityManager);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Pais> getByFilter(GenericFilter<Pais> filter){
		PaisFilter filtro = (PaisFilter) filter;
		Session session = this.entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(Pais.class);
		
		if (filtro.getCodigo() != null && !"".equals(filtro.getCodigo())) {
			criteria.add(Restrictions.eq("codigo", ((PaisFilter) filter).getCodigo()));
		}
		
		if (filtro.getNome() != null && !"".equals(filtro.getNome())){
			criteria.add(Restrictions.ilike("nome", filtro.getNome(),MatchMode.ANYWHERE));
		}
		
		return criteria.addOrder(Order.asc("nome")).list();
	}
}
