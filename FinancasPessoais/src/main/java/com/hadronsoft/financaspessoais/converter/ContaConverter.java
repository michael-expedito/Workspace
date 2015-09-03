package com.hadronsoft.financaspessoais.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import com.hadronsoft.financaspessoais.model.Conta;
import com.hadronsoft.financaspessoais.repository.ContaRepository;

@FacesConverter(forClass = Conta.class)
public class ContaConverter implements Converter {

	@Inject
	ContaRepository contaRepository;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Conta retorno = null;
		if (value != null) {
			retorno = contaRepository.getById(new Long(value));
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			return ((Conta) value).getId().toString();
		}
		return null;
	}

}
