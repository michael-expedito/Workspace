package com.hadronsoft.vendas.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import com.hadronsoft.vendas.model.Categoria;
import com.hadronsoft.vendas.repositories.CategoriaRepository;

@FacesConverter(forClass = Categoria.class)
public class CategoriaConverter implements Converter{


	@Inject
	CategoriaRepository categoriaRepository;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Categoria retorno = null;
		
		if (value != null && !"".equals(value)){
			Long id = new Long(value);
			retorno = categoriaRepository.getById(id);
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null){
			return ((Categoria) value).getId().toString();
		} 
		return null;
	}

}
