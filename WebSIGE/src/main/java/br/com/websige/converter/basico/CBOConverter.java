package br.com.websige.converter.basico;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import br.com.websige.model.basico.CBO;
import br.com.websige.repository.basico.CBORepository;

@FacesConverter(forClass = CBO.class)
public class CBOConverter implements Converter{

	@Inject
	CBORepository cboRepository;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		CBO retorno = null;
		
		if (value != null && !"".equals(value)){
			Long id = new Long(value);
			retorno = cboRepository.getById(id);
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null){
			CBO cbo = ((CBO) value);
			return cbo.getId() == null ? null : cbo.getId().toString();
		} 
		return null;
	}

}