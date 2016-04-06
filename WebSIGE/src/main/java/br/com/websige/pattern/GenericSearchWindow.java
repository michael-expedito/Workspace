package br.com.websige.pattern;

import org.primefaces.context.RequestContext;

import java.lang.reflect.Field;
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
		addLabelsInFiltros();
	}

	public void addLabelsInFiltros() {
		Class<?> classe = createFilter().getClass();
		
		for (Field field : classe.getDeclaredFields()) {
			if (field.isAnnotationPresent(FilterLabel.class)) {
				field.setAccessible(true);
				FilterLabel filterLabel = field.getAnnotation(FilterLabel.class);
				filtros.add(filterLabel.label());
			}
		}
	}

	@SuppressWarnings("unchecked")
	public void pesquisar() {
		filter = createFilter();
			
		setParameterInFilter();
		
		entityListed = repository.getByFilter((GenericFilter<Entity>) filter);
	}
	
	public void setParameterInFilter() {
		Class<?> classe = filter.getClass();
		
		for (Field field : classe.getDeclaredFields()) {
			if (field.isAnnotationPresent(FilterLabel.class)) {
				field.setAccessible(true);
				FilterLabel filterLabel = field.getAnnotation(FilterLabel.class);
				if (filtro.equals(filterLabel.label())){
					try {
						field.set(filter, valor);
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
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
