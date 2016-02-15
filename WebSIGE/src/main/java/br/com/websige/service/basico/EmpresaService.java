package br.com.websige.service.basico;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.websige.model.basico.Empresa;
import br.com.websige.repository.basico.EmpresaRepository;
import br.com.websige.pattern.GenericService;

public class EmpresaService extends GenericService<Empresa> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	public EmpresaService(EmpresaRepository empresaRepository) {
		super.repository = empresaRepository;
	}

}
