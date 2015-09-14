package com.hadronsoft.vendas.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import com.hadronsoft.vendas.model.Cliente;
import com.hadronsoft.vendas.repositories.ClienteRepository;

@FacesConverter(forClass = Cliente.class)
public class ClienteConverter implements Converter{

	@Inject
	ClienteRepository cliRepository;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Cliente retorno = null;
		
		if (value != null && !"".equals(value)){
			Long id = new Long(value);
			retorno = cliRepository.getById(id);
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null){
			return ((Cliente) value).getId().toString();
		} 
		return null;
	}

}
