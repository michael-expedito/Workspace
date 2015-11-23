package com.hadronsoft.financaspessoais.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.hadronsoft.financaspessoais.model.Cadastro;
import com.hadronsoft.financaspessoais.model.Categoria;
import com.hadronsoft.financaspessoais.security.SessionContext;

public class CategoriaRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	private EntityManager manager;

	@Inject
	public CategoriaRepository(EntityManager manager) {
		this.manager = manager;
	}

	public Categoria getById(Long id) {
		return this.manager.find(Categoria.class, id);
	}

	public List<Categoria> getAll() {
		return this.manager.createQuery("FROM Categoria WHERE cadastro = :cadastro ORDER BY ordenacao", Categoria.class)
				.setParameter("cadastro", (Cadastro) SessionContext.getInstance().getUsuarioLogado())
				.getResultList();
	}

	public void add(Categoria categoria) {
		this.manager.persist(categoria);
	}

	public void update(Categoria categoria) {
		this.manager.merge(categoria);
	}
	
	public void incrementaOrdenacaoCategorias(Categoria categoria) {
		this.manager.createNativeQuery("UPDATE CATEGORIA_CAT SET CAT_ORDENACAO = CAT_ORDENACAO+1 WHERE CAT_IDCADASTRO = :idcadastro AND CAT_ORDENACAO > :ordenacao")
			.setParameter("idcadastro", categoria.getCadastro().getId())
			.setParameter("ordenacao",categoria.getOrdenacao())
			.executeUpdate();
	}

	public List<Categoria> raizes() {
		return manager.createQuery("from Categoria where categoriaPai is null", Categoria.class)
				.getResultList();
	}
	
	public long getUltimaOrdenacao(Cadastro cadastro){
		Integer resultado = (Integer)this.manager.createNativeQuery("SELECT MAX(CAT_ORDENACAO) FROM CATEGORIA_CAT WHERE CAT_IDCADASTRO = :idcadastro")
				.setParameter("idcadastro", cadastro.getId())
				.getSingleResult();
		return resultado;
				
	}

	public void delete(Categoria categoria) {
		// TODO Auto-generated method stub
		
	}

	public void save(Categoria categoria) {
		// TODO Auto-generated method stub
		
	}

}
