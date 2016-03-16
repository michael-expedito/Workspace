package br.com.websige.searchwindow.basico;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import br.com.websige.filter.basico.EmpresaFilter;
import br.com.websige.model.basico.Empresa;
import br.com.websige.repository.basico.EmpresaRepository;

@Named
@ViewScoped
public class EmpresaSearchWindow /* extends GenericSearchWindow<Empresa>*/implements Serializable {

	private static final long serialVersionUID = 1L;

	
	
	public EmpresaSearchWindow() {
		filtros = new ArrayList<>();
		filtros.add("Codigo");
		filtros.add("CNPJ");
		filtros.add("Nome");
	}

	@Inject
	private EmpresaRepository empresas;
	
	private List<String> filtros;
	
	private String filtro;
	private String valor;
	
	
	private List<Empresa> empresasFiltradas;
	
	private EmpresaFilter filter;

	public void pesquisar() {
		filter = new EmpresaFilter();
		
		if (filtro.equals("Codigo")){
			filter.setCodigo(valor);
		}
		if (filtro.equals("CNPJ")){
			filter.setCNPJ(valor);
		}
		if (filtro.equals("Nome")){
			filter.setNome(valor);
		}
		empresasFiltradas = empresas.getByFilter(filter);
	}
	
	public void abrirDialogo() {
		Map<String, Object> opcoes = new HashMap<>();
		opcoes.put("modal", true);
		opcoes.put("resizable", false);
		opcoes.put("contentHeight", 470);
		
		RequestContext.getCurrentInstance().openDialog("/SearchWindow/Basico/EmpresaSearchWindow", opcoes, null);
	}
	
	public void selecionar(Empresa empresa) {
		RequestContext.getCurrentInstance().closeDialog(empresa);
	}
	

	public List<Empresa> getEmpresasFiltradas() {
		return empresasFiltradas;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}
	
	public List<String> getFiltros() {
		return filtros;
	}

	public void setFiltros(List<String> filtros) {
		this.filtros = filtros;
	}
	
	
}
