package br.com.websige.controller.basico;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.websige.filter.basico.ClienteFilter;
import br.com.websige.model.basico.Cliente;
import br.com.websige.pattern.CadastroBean;
import br.com.websige.repository.basico.ClienteRepository;
import br.com.websige.service.basico.ClienteService;

@Named
@ViewScoped
public class ClienteBean extends CadastroBean<Cliente, ClienteFilter> implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public ClienteBean(ClienteRepository repository, ClienteService service) {
		super(repository, service);
	}

	@Override
	public Cliente createEntity() {
		return new Cliente();
	}

	@Override
	protected String getParameterURL(Cliente entityConsulted) {
		return null;
	}

	@Override
	public ClienteFilter createFilter() {
		return new ClienteFilter();
	}

	@Override
	public void createSubEntities() {
		// TODO Auto-generated method stub
	}

}
