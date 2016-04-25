package com.hadronsoft.vendas.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import com.hadronsoft.vendas.model.Pedido;
import com.hadronsoft.vendas.repositories.PedidoRepository;

@FacesConverter(forClass = Pedido.class)
public class PedidoConverter implements Converter{

	@Inject
	PedidoRepository pedRepository;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Pedido retorno = null;
		
		if (value != null && !"".equals(value)){
			Long id = new Long(value);
			retorno = pedRepository.getById(id);
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null){
			Pedido produto = (Pedido) value;
			return produto.getId() == null ? null : produto.getId().toString();
		} 
		return null;
	}

}
