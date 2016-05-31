package br.com.websige.service.basico;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.websige.model.basico.Cliente;
import br.com.websige.pattern.GenericService;
import br.com.websige.repository.basico.ClienteRepository;

public class ClienteService extends GenericService<Cliente> implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	public ClienteService(ClienteRepository clienteRepository) {
		super.repository = clienteRepository;
	}
}
