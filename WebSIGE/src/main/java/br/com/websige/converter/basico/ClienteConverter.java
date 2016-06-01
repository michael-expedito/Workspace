package br.com.websige.converter.basico;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import br.com.websige.model.basico.Cliente;
import br.com.websige.repository.basico.ClienteRepository;

@FacesConverter(forClass = Cliente.class)
public class ClienteConverter implements Converter{

	@Inject
	ClienteRepository repository;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Cliente retorno = null;
		
		if (value != null && !"".equals(value)){
			Long id = new Long(value);
			retorno = repository.getById(id);
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null){
			Cliente entity = ((Cliente) value);
			return entity.getId() == null ? null : entity.getId().toString();
		} 
		return null;
	}

}
