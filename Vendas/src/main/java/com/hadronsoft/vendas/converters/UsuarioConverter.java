package com.hadronsoft.vendas.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import com.hadronsoft.vendas.model.Usuario;
import com.hadronsoft.vendas.repositories.UsuarioRepository;

@FacesConverter(forClass = Usuario.class)
public class UsuarioConverter implements Converter{

	@Inject
	UsuarioRepository usuRepository;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Usuario retorno = null;
		
		if (value != null && !"".equals(value)){
			Long id = new Long(value);
			retorno = usuRepository.getById(id);
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null){
			return ((Usuario) value).getId().toString();
		} 
		return null;
	}

}
