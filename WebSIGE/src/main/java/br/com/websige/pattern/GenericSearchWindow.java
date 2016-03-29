package br.com.websige.pattern;

import org.primefaces.context.RequestContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenericSearchWindow<Entity,Filter> {
	
	private Filter filter;
	
	private GenericRepository<Entity> repository;
	
	private String filtro;
	
	private List<String> filtros;
	
	private String valor;
	
	private List<Entity> entityListed;
	
	private String directory;
	
	
	public GenericSearchWindow(GenericRepository<Entity> repository) {
		super();
		this.repository = repository;
		filtros = new ArrayList<>();
	}

	@SuppressWarnings("unchecked")
	public void pesquisar() {
		filter = createFilter();
			
		setParameterInFilter();
		
		entityListed = repository.getByFilter((GenericFilter<Entity>) filter);
	}
	
	public void setParameterInFilter() {
		// TODO Auto-generated method stub
	}

	public void openSearch() {
		Map<String, Object> opcoes = new HashMap<>();
		opcoes.put("modal", true);
		opcoes.put("resizable", false);
		opcoes.put("contentHeight", 470);
		
		RequestContext.getCurrentInstance().openDialog(directory , opcoes, null); // "/SearchWindow/Basico/EmpresaSearchWindow"
	}
		
	public void select(Entity entity){
		RequestContext.getCurrentInstance().closeDialog(entity);
	}
	
	public Filter createFilter(){
		return null;
	}

	public Filter getFilter() {
		return filter;
	}

	public void setFilter(Filter filter) {
		this.filter = filter;
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

	public List<String> getFiltros() {
		return filtros;
	}

	public void setFiltros(List<String> filtros) {
		this.filtros = filtros;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public List<Entity> getEntityListed() {
		return entityListed;
	}

	public void setEntityListed(List<Entity> entityListed) {
		this.entityListed = entityListed;
	}

	public void setDirectory(String directory) {
		this.directory = directory;
	}
	
}
