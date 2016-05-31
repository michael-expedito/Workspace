package br.com.websige.repository.basico;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import br.com.websige.filter.basico.FornecedorFilter;
import br.com.websige.model.basico.Fornecedor;
import br.com.websige.model.basico.PessoaFisica;
import br.com.websige.model.basico.PessoaJuridica;
import br.com.websige.pattern.GenericFilter;
import br.com.websige.pattern.GenericRepository;

public class FornecedorRepository extends GenericRepository<Fornecedor> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	public FornecedorRepository(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<Fornecedor> getByFilter(GenericFilter<Fornecedor> filter) {
		FornecedorFilter fornecedorFilter = (FornecedorFilter) filter;
		
		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Fornecedor> criteriaQuery = builder.createQuery(Fornecedor.class);
		
		Root<Fornecedor> f = criteriaQuery.from(Fornecedor.class);
		f.fetch("pessoaFisica",JoinType.LEFT);
		f.fetch("pessoaJuridica",JoinType.LEFT);

		Join<Fornecedor, PessoaFisica> pf = (Join)f.fetch("pessoaFisica",JoinType.LEFT);
		Join<Fornecedor, PessoaJuridica> pj = (Join) f.fetch("pessoaJuridica",JoinType.LEFT);
		
		if (fornecedorFilter.getCodigo() != null && !"".equals(fornecedorFilter.getCodigo())) {
			criteriaQuery.where(builder.equal(f.get("codigo"), ((FornecedorFilter) filter).getCodigo()));
		}
		
		if (fornecedorFilter.getDescricao() != null && !"".equals(fornecedorFilter.getDescricao())) {
			criteriaQuery.where(builder.equal(f.get("descricao"), ((FornecedorFilter) filter).getDescricao()));
		}
		
		if (fornecedorFilter.getCnpj() != null && !"".equals(fornecedorFilter.getCnpj())) {
			criteriaQuery.where(builder.equal(pj.get("cnpj"), ((FornecedorFilter) filter).getCnpj()));
		}
		
		if (fornecedorFilter.getRazaoSocial() != null && !"".equals(fornecedorFilter.getRazaoSocial())) {
			criteriaQuery.where(builder.like(pj.<String>get("razaoSocial"), "%"+((FornecedorFilter) filter).getRazaoSocial()+"%"));
		}
		
		if (fornecedorFilter.getCpf() != null && !"".equals(fornecedorFilter.getCpf())) {
			criteriaQuery.where(builder.equal(pf.get("cpf"), ((FornecedorFilter) filter).getCpf()));
		}
		
		if (fornecedorFilter.getNomeFisico() != null && !"".equals(fornecedorFilter.getNomeFisico())) {
			criteriaQuery.where(builder.like(pj.<String>get("nome"), "%"+((FornecedorFilter) filter).getNomeFisico()+"%"));
		}
		
		
		TypedQuery<Fornecedor> query = this.entityManager.createQuery(criteriaQuery);
		return query.getResultList();
		
		
		
		}
	
	
}
