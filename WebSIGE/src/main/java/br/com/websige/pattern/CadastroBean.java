package br.com.websige.pattern;

import java.io.IOException;
import java.util.List;

import javax.faces.context.FacesContext;

import br.com.websige.util.FacesUtil;

public abstract class CadastroBean<Entity,Filter> {

	private Entity entity;
	private Filter filter;
	private List<Entity> listEntity;
	private GenericRepository<Entity> repository;
	private GenericService<Entity> service;
	
	private String directory;
	
	public abstract Entity createEntity();
	public abstract Filter createFilter();
	public abstract void createSubEntities();
	
	public CadastroBean(GenericRepository<Entity> repository, GenericService<Entity> service) {
		if (getEntity() == null) {
			setEntity(createEntity());
			createSubEntities();
		}
		this.repository = repository;
		this.service = service;
	}
	
	public void startCadastro() {
		if (getEntity() == null) {
			setEntity(createEntity());
		}
		createSubEntities();
	}
	
	public void startConsulta() {
		if (getFilter() == null) {
			setFilter(createFilter());		
		}
		listEntity = getRepository().getAll();
	}

	public void salvar() {
		try {
			service.process(getEntity());
			FacesUtil.addListMessageService(service.messages);
			if(!service.hasFatalError()){
				setEntity(createEntity());
				FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
				FacesContext.getCurrentInstance().getExternalContext().redirect("/WebSIGE"+directory+"Cadastro.xhtml");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			createSubEntities();
		}	
	}
	
	public void limpar(){
		setEntity(createEntity());
	}
	
	public void excluir() {
		try {
			service.revertProcess(getEntity());
			FacesUtil.addListMessageService(service.messages);
			if(!service.hasFatalError()){
				setEntity(createEntity());
				FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
				FacesContext.getCurrentInstance().getExternalContext().redirect("/WebSIGE"+directory+"Cadastro.xhtml");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			createSubEntities();
		}
	}
	
	@SuppressWarnings("unchecked")
	public void consult(){
		listEntity = getRepository().getByFilter((GenericFilter<Entity>) filter);
	}
	
	protected String getParameterURL(Entity entityConsulted){
		return "entity=" + ((GenericEntity) entityConsulted).getId();
	};
	
	protected String getDirectory() {
		return directory;
	}

	protected void setDirectory(String directory) {
		this.directory = directory;
	}
	
	public String directoryConsult(){
		return this.directory + "Consulta?faces-redirect=true";
	}
	
	public String directoryNew(){
		return this.directory + "Cadastro?faces-redirect=true";
	}
	
	public String openEntity(Entity entityConsulted){
		return this.directory + "Cadastro?faces-redirect=true&" + getParameterURL(entityConsulted);
	}

	public boolean getRenderedSalvar()
	{
		return true;
	}
	public boolean getRenderedExcluir()
	{
		return true;
	}
	public boolean getRenderedConsultar()
	{
		return true;
	}
	public boolean getDisabledSalvar()
	{
		return false;
	}
	public boolean getDisabledExcluir()
	{
		return false;
	}
	public boolean getDisabledConsultar()
	{
		return false;
	}
	public Entity getEntity() {
		return entity;
	}
	public void setEntity(Entity entity) {
		this.entity = entity;
	}
	public Filter getFilter() {
		return filter;
	}
	public void setFilter(Filter filter) {
		this.filter = filter;
	}

	public GenericRepository<Entity> getRepository() {
		return repository;
	}

	public void setRepository(GenericRepository<Entity> repository) {
		this.repository = repository;
	}

	public GenericService<Entity> getService() {
		return service;
	}

	public void setService(GenericService<Entity> service) {
		this.service = service;
	}

	public List<Entity> getListEntity() {
		return listEntity;
	}

	public void setListEntity(List<Entity> listEntity) {
		this.listEntity = listEntity;
	}

	public List<Entity> createListEntity(){
		return null;
	}
}
