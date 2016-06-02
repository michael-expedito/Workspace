package br.com.websige.converter.crm;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import br.com.websige.model.crm.CategoriaCliente;
import br.com.websige.repository.crm.CategoriaClienteRepository;

@FacesConverter(forClass = CategoriaCliente.class, value = "CategoriaClienteConverter")
public class CategoriaClienteConverter implements Converter{

	@Inject
	CategoriaClienteRepository repository;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		CategoriaCliente retorno = null;
		
		if (value != null && !"".equals(value)){
			Long id = new Long(value);
			retorno = repository.getById(id);
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null){
			CategoriaCliente entity = ((CategoriaCliente) value);
			return entity.getId() == null ? null : entity.getId().toString();
		} 
		return null;
	}

}
