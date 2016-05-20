package br.com.websige.converter.basico;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import br.com.websige.model.basico.endereco.Pais;
import br.com.websige.repository.basico.PaisRepository;

@FacesConverter(forClass = Pais.class, value = "PaisConverter")
public class PaisConverter implements Converter{

	@Inject
	PaisRepository repository;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Pais retorno = null;
		
		if (value != null && !"".equals(value)){
			Long id = new Long(value);
			retorno = repository.getById(id);
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null){
			Pais retorno = ((Pais) value);
			return retorno.getId() == null ? null : retorno.getId().toString();
		} 
		return null;
	}

}