package br.com.websige.searchwindow.basico;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import br.com.websige.model.basico.Empresa;
import br.com.websige.pattern.GenericFilter;
import br.com.websige.pattern.GenericSearchWindow;
import br.com.websige.repository.basico.EmpresaRepository;

@Named
@ViewScoped
public class EmpresaSearchWindow /* extends GenericSearchWindow<Empresa>*/implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EmpresaRepository empresas;
	
	private String nome;
	
	private List<Empresa> empresasFiltradas;
	
	GenericFilter<Empresa> filter;

	public void pesquisar() {
		
		empresasFiltradas = empresas.getByFilter(filter);
	}
	
	public void abrirDialogo() {
		Map<String, Object> opcoes = new HashMap<>();
		opcoes.put("modal", true);
		opcoes.put("resizable", false);
		opcoes.put("contentHeight", 470);
		
		RequestContext.getCurrentInstance().openDialog("SelecaoEmpresa", opcoes, null);
	}
	
	public void selecionar(Empresa empresa) {
		RequestContext.getCurrentInstance().closeDialog(empresa);
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Empresa> getClientesFiltrados() {
		return empresasFiltradas;
	}
	
	
}
