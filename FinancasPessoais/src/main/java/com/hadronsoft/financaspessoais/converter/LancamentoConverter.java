package com.hadronsoft.financaspessoais.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import com.hadronsoft.financaspessoais.model.Lancamento;
import com.hadronsoft.financaspessoais.repository.LancamentoRepository;

@FacesConverter(forClass = Lancamento.class)
public class LancamentoConverter implements Converter {
	
	@Inject
	LancamentoRepository lctRepository;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Lancamento retorno = null;
		if (value != null && !"".equals(value)) {
			retorno = this.lctRepository.getById(new Long(value));
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Lancamento lancamento = ((Lancamento) value);
			return lancamento.getId() == null ? null : lancamento.getId().toString();
		}
		return null;
	}
}