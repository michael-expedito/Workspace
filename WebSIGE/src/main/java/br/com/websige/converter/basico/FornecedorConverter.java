package br.com.websige.converter.basico;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import br.com.websige.model.basico.Fornecedor;
import br.com.websige.repository.basico.FornecedorRepository;

@FacesConverter(forClass = Fornecedor.class)
public class FornecedorConverter implements Converter{

	@Inject
	FornecedorRepository fornecedorRepository;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Fornecedor retorno = null;
		
		if (value != null && !"".equals(value)){
			Long id = new Long(value);
			retorno = fornecedorRepository.getById(id);
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null){
			Fornecedor fornecedor = ((Fornecedor) value);
			return fornecedor.getId() == null ? null : fornecedor.getId().toString();
		} 
		return null;
	}

}