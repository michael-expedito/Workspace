package br.com.websige.converter.basico;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import br.com.websige.model.basico.Filial;
import br.com.websige.repository.basico.FilialRepository;

@FacesConverter(forClass = Filial.class)
public class FilialConverter implements Converter{

	@Inject
	FilialRepository filialRepository;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Filial retorno = null;
		
		if (value != null && !"".equals(value)){
			Long id = new Long(value);
			retorno = filialRepository.getById(id);
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null){
			Filial filial = ((Filial) value);
			return filial.getId() == null ? null : filial.getId().toString();
		} 
		return null;
	}

}
