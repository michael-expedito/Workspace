package br.com.websige.converter.basico;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import br.com.websige.model.basico.Empresa;
import br.com.websige.repository.basico.EmpresaRepository;

@FacesConverter(forClass = Empresa.class)
public class EmpresaConverter implements Converter{

	@Inject
	EmpresaRepository empresaRepository;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Empresa retorno = null;
		
		if (value != null && !"".equals(value)){
			Long id = new Long(value);
			retorno = empresaRepository.getById(id);
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null){
			Empresa empresa = ((Empresa) value);
			return empresa.getId() == null ? null : empresa.getId().toString();
		} 
		return null;
	}
}
