package com.hadronsoft.financaspessoais.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.hadronsoft.financaspessoais.model.Lancamento;
import com.hadronsoft.financaspessoais.repository.filter.LancamentoFilter;

public class LancamentoRepository implements Serializable  {

	private static final long serialVersionUID = 1L;
	
	private EntityManager manager;

	@Inject
	public LancamentoRepository(EntityManager manager) {
		this.manager = manager;
	}

	public List<Lancamento> getAll() {
		TypedQuery<Lancamento> query = manager.createQuery("from Lancamento", Lancamento.class);
		return query.getResultList();
	}
	
	public Lancamento getById(Long id){
		return this.manager.find(Lancamento.class, id);
	}
	
	public void add(Lancamento lancamento) {
		this.manager.persist(lancamento);
	}
	
	public Lancamento update (Lancamento lancamento){
		return this.manager.merge(lancamento);
	}
	
	public void delete(Lancamento lancamento) {
		this.manager.remove(this.manager.getReference(Lancamento.class, lancamento.getId()));
	}
	
	@SuppressWarnings("unchecked")
	public List<Lancamento> getByFilter(LancamentoFilter filter ){
		Session session = this.manager.unwrap(Session.class);
		
		Criteria criteria = session.createCriteria(Lancamento.class);
		
		if (filter.getPeriodoInicial() != null) {
			criteria.add(Restrictions.ge("dataVencimento", filter.getPeriodoInicial()));
		}
		
		if (filter.getPeriodoFinal() != null) {
			criteria.add(Restrictions.le("dataVencimento", filter.getPeriodoFinal()));
		}
		
		//if (filter.getConta() != null){
		//	criteria.add(Restrictions.("conta", filter.getConta()));
		//}
		
		return criteria.addOrder(Order.asc("dataVencimento")).list();
	}
}
