package br.com.websige.converter.basico;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import br.com.websige.model.basico.endereco.Cidade;
import br.com.websige.repository.basico.CidadeRepository;

@FacesConverter(forClass = Cidade.class, value="cidadeConverter")
public class CidadeConverter implements Converter{

	@Inject
	CidadeRepository repository;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Cidade retorno = null;
		
		if (value != null && !"".equals(value)){
			Long id = new Long(value);
			retorno = repository.getById(id);
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null){
			Cidade entity = ((Cidade) value);
			return entity.getId() == null ? null : entity.getId().toString();
		} 
		return null;
	}
}
