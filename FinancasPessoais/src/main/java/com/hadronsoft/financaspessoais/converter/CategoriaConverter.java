package com.hadronsoft.financaspessoais.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import com.hadronsoft.financaspessoais.model.Categoria;
import com.hadronsoft.financaspessoais.repository.CategoriaRepository;

@FacesConverter(forClass = Categoria.class)
public class CategoriaConverter implements Converter {

	@Inject
	private CategoriaRepository catRepository;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {

		Categoria retorno = null;

		if (value != null && !"".equals(value)) {
			retorno = catRepository.getById(new Long(value));
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			return ((Categoria) value).getId().toString();
		}
		return null;
	}

}
