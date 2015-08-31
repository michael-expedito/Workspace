package com.hadronsoft.vendas.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import com.hadronsoft.vendas.model.Produto;
import com.hadronsoft.vendas.repositories.ProdutoRepository;

@FacesConverter(forClass = Produto.class)
public class ProdutoConverter implements Converter{
	@Inject
	ProdutoRepository produtoRepository;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Produto retorno = null;
		
		if (value != null && !"".equals(value)){
			Long id = new Long(value);
			retorno = produtoRepository.getById(id);
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null){
			Produto produto = (Produto) value;
			return produto.getId() == null ? null : produto.getId().toString();
		} 
		return null;
	}

}