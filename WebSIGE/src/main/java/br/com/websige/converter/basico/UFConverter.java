package br.com.websige.converter.basico;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import br.com.websige.model.basico.endereco.UF;
import br.com.websige.repository.basico.UFRepository ;

@FacesConverter(forClass = UF.class)
public class UFConverter implements Converter{

	@Inject
	UFRepository repository;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		UF retorno = null;
		
		if (value != null && !"".equals(value)){
			String codigo = value;
			retorno = repository.getByCodigo(codigo);
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null){
			UF retorno = ((UF) value);
			return retorno.getCodigo() == null ? null : retorno.getCodigo().toString();
		} 
		return null;
	}

}