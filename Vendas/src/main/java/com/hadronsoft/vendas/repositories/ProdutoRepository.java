package com.hadronsoft.vendas.repositories;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.hadronsoft.vendas.model.Produto;
import com.hadronsoft.vendas.repositories.filters.ProdutoFilter;

public class ProdutoRepository implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public void add(Produto produto) {
		this.manager.persist(produto);
	}
	
	public Produto update(Produto produto){
		return this.manager.merge(produto);
	}
	
	public void delete(Produto produto){
		this.manager.remove(this.manager.getReference(Produto.class, produto.getId()));
	}
	
	public Produto getById(Long id){
		return this.manager.find(Produto.class, id);
	}
	
	public List<Produto> getAll(){
		return this.manager.createQuery("from Produto", Produto.class).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Produto> getByFilter(ProdutoFilter filtro){
		Session session = this.manager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(Produto.class);
		
		if (filtro.getSku() != null && !filtro.getSku().isEmpty() && !"".equals(filtro.getSku())){
			criteria.add(Restrictions.eq("sku", filtro.getSku()));
		}
		if (filtro.getNome() != null && !filtro.getNome().isEmpty() && !"".equals(filtro.getNome())){
			criteria.add(Restrictions.ilike("nome", filtro.getNome(), MatchMode.ANYWHERE));
		}
		
		return criteria.addOrder(Order.asc("nome")).list();
		
	}

	public List<Produto> getByName(String nome) {
		return this.manager.createQuery("from Produto where upper(nome) like :nome", Produto.class)
				.setParameter("nome", nome.toUpperCase() + "%")
				.getResultList();
	}

}
