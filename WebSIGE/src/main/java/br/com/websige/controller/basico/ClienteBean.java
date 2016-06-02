package br.com.websige.controller.basico;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.websige.filter.basico.ClienteFilter;
import br.com.websige.model.basico.CBO;
import br.com.websige.model.basico.Cliente;
import br.com.websige.model.basico.Email;
import br.com.websige.model.basico.Imagem;
import br.com.websige.model.basico.PessoaFisica;
import br.com.websige.model.basico.PessoaJuridica;
import br.com.websige.model.basico.Segmento;
import br.com.websige.model.basico.Telefone;
import br.com.websige.model.basico.endereco.Endereco;
import br.com.websige.model.basico.enuns.EstadoCivil;
import br.com.websige.model.basico.enuns.TipoPessoa;
import br.com.websige.model.crm.CategoriaCliente;
import br.com.websige.model.crm.RedeSocial;

import br.com.websige.pattern.CadastroBean;
import br.com.websige.repository.basico.ClienteRepository;
import br.com.websige.service.basico.ClienteService;
import br.com.websige.util.framework.FrameworkFunctions;

@Named
@ViewScoped
public class ClienteBean extends CadastroBean<Cliente, ClienteFilter> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	public ClienteBean(ClienteRepository repository, ClienteService service) {
		super(repository, service);
		setDirectory("/Restrict/Basico/Cadastro/Cliente/");
	}

	@Override
	public Cliente createEntity() {
		return new Cliente();
	}

	@Override
	public ClienteFilter createFilter() {
		return new ClienteFilter();
	}

	@Override
	public void createSubEntities() {
		if (getEntity().getPessoaJuridica() == null) {
			getEntity().setPessoaJuridica(new PessoaJuridica());
		}
		if (getEntity().getPessoaFisica() == null) {
			getEntity().setPessoaFisica(new PessoaFisica());
		}
		if (getEntity().getEnderecos() == null) {
			getEntity().setEnderecos(new ArrayList<Endereco>());
		}
		if (getEntity().getEmails() == null) {
			getEntity().setEmails(new ArrayList<Email>());
		}
		if (getEntity().getTelefones() == null) {
			getEntity().setTelefones(new ArrayList<Telefone>());
		}
		if (getEntity().getRedeSocial() == null) {
			getEntity().setRedeSocial(new RedeSocial());
		}
		if (getEntity().getSegmento() == null){
			getEntity().setSegmento(new Segmento());
		}
		if (getEntity().getImagem() == null){
			getEntity().setImagem(new Imagem());
		}
		if (getEntity().getCategoriaCliente() == null){
			getEntity().setCategoriaCliente(new CategoriaCliente());
		}
	}

	public Cliente getCliente() {
		return (Cliente) getEntity();
	}

	public void setCliente(Cliente entity) {
		setEntity(entity);
	}

	// Geters e Seters de Enuns
	public TipoPessoa[] getTipoPessoas() {
		return TipoPessoa.values();
	}

	public EstadoCivil[] getEstadosCivis() {
		return EstadoCivil.values();
	}

	// Métodos específicos da tela de Fornecedor
	public void cboSelecionado(org.primefaces.event.SelectEvent event) {
		CBO cbo = (CBO) event.getObject();
		getEntity().getPessoaFisica().setCbo(cbo);
	}

	public void enderecoRetornado(org.primefaces.event.SelectEvent event) {
		Endereco endereco = (Endereco) event.getObject();
		if (endereco != null) {
			if (!FrameworkFunctions.checkEmpty(endereco)) {
				if (endereco.getId() == null) {
					getEntity().getEnderecos().add(endereco);
				} else {
					getEntity().getEnderecos().set(endereco.getId().intValue(), endereco);
				}
			}
		}
	}
	public void removerEndereco() {
		Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		String id = params.get("id");
		getEntity().getEnderecos().remove(Integer.parseInt(id));
	}
	
	public void emailRetornado(org.primefaces.event.SelectEvent event) {
		Email email = (Email) event.getObject();
		if (email != null) {
			if (!FrameworkFunctions.checkEmpty(email)) {
				if (email.getId() == null) {
					getEntity().getEmails().add(email);
				} else {
					getEntity().getEmails().set(email.getId().intValue(), email);
				}
			}
		}
	}
	public void removerEmail() {
		Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		String id = params.get("id");
		getEntity().getEmails().remove(Integer.parseInt(id));
	}
	
	public void telefoneRetornado(org.primefaces.event.SelectEvent event) {
		Telefone telefone = (Telefone) event.getObject();
		if (telefone != null) {
			if (!FrameworkFunctions.checkEmpty(telefone)) {
				if (telefone.getId() == null) {
					getEntity().getTelefones().add(telefone);
				} else {
					getEntity().getTelefones().set(telefone.getId().intValue(), telefone);
				}
			}
		}
	}
	public void removerTelefone() {
		Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		String id = params.get("id");
		getEntity().getTelefones().remove(Integer.parseInt(id));
	}

}
