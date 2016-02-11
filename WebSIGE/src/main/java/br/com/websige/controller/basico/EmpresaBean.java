package br.com.websige.controller.basico;

import java.io.Serializable;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.websige.model.basico.Empresa;
import br.com.websige.service.basico.EmpresaService;
import br.com.websige.util.FacesUtil;

@Named
@javax.faces.view.ViewScoped
public class EmpresaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Empresa empresa;

	@Inject
	private EmpresaService empresaService;

	public void prepararCadastro() {
		empresa = new Empresa();
	}

	public void salvar() {
		empresaService.process(empresa);
		FacesUtil.addListMessageService(empresaService.messages);
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

}
