package br.com.websige.converter.basico;

import java.io.Serializable;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import br.com.websige.model.basico.Segmento;
import br.com.websige.repository.basico.SegmentoRepository;

@FacesConverter(forClass = Segmento.class, value = "SegmentoConverter")
public class SegmentoConverter implements Converter, Serializable {  
	  
	private static final long serialVersionUID = 1L;  
	
	@Inject
	SegmentoRepository repository;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Segmento retorno = null;
		
		if (value != null && !"".equals(value)){
			Long id = new Long(value);
			retorno = repository.getById(id);
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null){
			Segmento entity = ((Segmento) value);
			return entity.getId() == null ? null : entity.getId().toString();
		} 
		return null;
	}
}
