package br.com.websige.pattern;

import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import br.com.websige.pattern.annotations.ResourceEntity;
import br.com.websige.util.framework.MessageService;
import br.com.websige.util.framework.TypeMessageService;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

@SuppressWarnings("unchecked")
public class GenericRepository<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	protected EntityManager entityManager;

	@Inject
	public GenericRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public T getById(Long pk) {
		return (T) entityManager.find(getTypeClass(), pk);
	}

	private Class<?> getTypeClass() {
		Class<?> clazz = (Class<?>) ((ParameterizedType) this.getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
		return clazz;
	}

	public void persist(T entity) {
		entityManager.merge(entity);
	}

	public void delete(T entity) {
		entityManager.remove(this.entityManager.getReference(getTypeClass(), ((GenericEntity<T>) entity).getId()));
	}

	public List<T> getAll() {
		return entityManager.createQuery(("FROM " + getTypeClass().getName())).getResultList();
	}

	public void validateEntity(T entity, List<MessageService> messages) {

	}

	public void validateSaveEntityBasic(T entity, List<MessageService> messages) {
		Class<?> classe = entity.getClass();
		String resourceDirectory, fieldNameTranslated = null;
		ResourceBundle bundle = null;
		if (classe.isAnnotationPresent(ResourceEntity.class)){
			ResourceEntity resourceEntity = classe.getAnnotation(ResourceEntity.class);
			resourceDirectory = resourceEntity.resourceDirectory();
			if (resourceDirectory != null){
				Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
		        bundle = ResourceBundle.getBundle(resourceDirectory, locale);
			}
		}

		for (Field field : classe.getDeclaredFields()) {
			try {
				field.setAccessible(true);
				Object valueObj = field.get(entity);
				
				if (field.isAnnotationPresent(Column.class)) {
					
					if (bundle != null){
						fieldNameTranslated = bundle.getString(field.getName());
					} else {
						fieldNameTranslated = field.getName();
					}
					
					Column coluna = field.getAnnotation(Column.class);
					if (valueObj != null) {	
						String value = valueObj.toString();
						if ((coluna.nullable() == false) && value.trim() == "") {
							messages.add(new MessageService("INT0002", fieldNameTranslated + " é um campo obrigatório",
									TypeMessageService.FATAL));
						}
						if ((coluna.length() > 0) && (value.length() > coluna.length())) {
							messages.add(new MessageService("INT0003", "O campo " + fieldNameTranslated
									+ " pode ter no máximo " + coluna.length() + " caracteres.",
									TypeMessageService.FATAL));
						}
					} else if (valueObj == null && coluna.nullable() == false) {
						messages.add(new MessageService("INT0002", fieldNameTranslated + " é um campo obrigatório",
								TypeMessageService.FATAL));
					}
				}
				if (field.isAnnotationPresent(ManyToOne.class)) {
					JoinColumn colunaJoin = field.getAnnotation(JoinColumn.class);
					if (colunaJoin.nullable() == false && valueObj == null) {
						if (bundle != null){
							fieldNameTranslated = bundle.getString(field.getName());
						} else {
							fieldNameTranslated = field.getName();
						}
						messages.add(new MessageService("INT0002", fieldNameTranslated + " é um campo obrigatório",
								TypeMessageService.FATAL));
					} else if (valueObj != null){
						validateSaveEntityBasic((T) field.get(entity), messages);
					}
				}
				if (field.isAnnotationPresent(ManyToMany.class) || field.isAnnotationPresent(OneToMany.class)) {
					field.setAccessible(true);
					List<Object> valueObjList = (List<Object>) field.get(entity);
					for (Object object : valueObjList) {
						validateSaveEntityBasic((T) object, messages);
					}
				}
			} catch (IllegalArgumentException e) {
				messages.add(new MessageService("INT000?", "Erro não rastreado ao validar a entidade",
						TypeMessageService.FATAL));
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				messages.add(new MessageService("INT000?", "Erro não rastreado ao validar a entidade",
						TypeMessageService.FATAL));
				e.printStackTrace();
			}
		}
	}

	public List<T> getByFilter(GenericFilter<T> filter) {
		return null;
	}
}
