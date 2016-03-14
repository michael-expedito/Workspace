package br.com.websige.pattern;

import org.primefaces.context.RequestContext;

import java.util.HashMap;
import java.util.Map;

public class GenericSearchWindow<T> {
	
	private GenericFilter<T> filter;
	
	public void openSearch() {
		Map<String, Object> opcoes = new HashMap<>();
		opcoes.put("modal", true);
		opcoes.put("resizable", false);
		opcoes.put("contentHeight", 470);
		
		RequestContext.getCurrentInstance().openDialog("SelecaoCliente", opcoes, null);
	}
	
	public void selecionar(T entity) {
		RequestContext.getCurrentInstance().closeDialog(entity);
	}
	
	public void getEntityByFilter(){
		
	}
}
