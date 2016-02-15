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

import br.com.websige.filter.basico.EmpresaFilter;
import br.com.websige.model.basico.Empresa;
import br.com.websige.pattern.GenericRepository;

public class EmpresaRepository extends GenericRepository<Long, Empresa> implements Serializable  {
	
	private static final long serialVersionUID = 1L;

	@Inject
	public EmpresaRepository(EntityManager entityManager) {
		super(entityManager);
	}	
	
	public List<Empresa> getByFilter(EmpresaFilter filter){
		Session session = this.entityManager.unwrap(Session.class);
		
		Criteria criteria = session.createCriteria(Empresa.class);
		
		if (filter.getCodigo() != null && !"".equals(filter.getCodigo())) {
			criteria.add(Restrictions.eq("codigo", filter.getCodigo()));
		}
		
		if (filter.getCNPJ() != null && !"".equals(filter.getCNPJ())) {
			criteria.add(Restrictions.eq("cnpj", filter.getCNPJ()));
		}
		
		if (filter.getNome() != null && !"".equals(filter.getNome())){
			criteria.add(Restrictions.ilike("nome", filter.getNome(),MatchMode.ANYWHERE));
		}
		
		return criteria.addOrder(Order.asc("codigo")).list();
	}
}
