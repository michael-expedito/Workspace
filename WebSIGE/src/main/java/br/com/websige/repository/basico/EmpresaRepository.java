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
import br.com.websige.pattern.GenericFilter;
import br.com.websige.pattern.GenericRepository;

public class EmpresaRepository extends GenericRepository<Empresa> implements Serializable  {
	
	private static final long serialVersionUID = 1L;

	@Inject
	public EmpresaRepository(EntityManager entityManager) {
		super(entityManager);
	}	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Empresa> getByFilter(GenericFilter<Empresa> filter){
		EmpresaFilter empresaFilter = (EmpresaFilter) filter;
		Session session = this.entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(Empresa.class);
		
		if (empresaFilter.getCodigo() != null && !"".equals(empresaFilter.getCodigo())) {
			criteria.add(Restrictions.eq("codigo", ((EmpresaFilter) filter).getCodigo()));
		}
		
		if (empresaFilter.getCNPJ() != null && !"".equals(empresaFilter.getCNPJ())) {
			criteria.add(Restrictions.eq("cnpj", ((EmpresaFilter) filter).getCNPJ()));
		}
		
		if (empresaFilter.getNome() != null && !"".equals(empresaFilter.getNome())){
			criteria.add(Restrictions.ilike("nome", empresaFilter.getNome(),MatchMode.ANYWHERE));
		}
		
		return criteria.addOrder(Order.asc("codigo")).list();
	}
}
