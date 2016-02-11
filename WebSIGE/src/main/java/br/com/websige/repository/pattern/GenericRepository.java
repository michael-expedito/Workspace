package br.com.websige.repository.pattern;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.validation.constraints.NotNull;

import br.com.websige.util.framework.MessageService;
import br.com.websige.util.framework.TypeMessageService;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.List;

@SuppressWarnings("unchecked")
public class GenericRepository<PK, T> implements Serializable {

	private static final long serialVersionUID = 1L;

	protected EntityManager entityManager;

	@Inject
	public GenericRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public T getById(PK pk) {
		return (T) entityManager.find(getTypeClass(), pk);
	}

	private Class<?> getTypeClass() {
		Class<?> clazz = (Class<?>) ((ParameterizedType) this.getClass().getGenericSuperclass())
				.getActualTypeArguments()[1];
		return clazz;
	}

	public void persist(T entity) {
		entityManager.merge(entity);
	}

	public void delete(T entity) {
		entityManager.remove(entity);
	}

	public List<T> findAll() {
		return entityManager.createQuery(("FROM " + getTypeClass().getName())).getResultList();
	}

	public void validateEntity(T entity, List<MessageService> messages) {

	}

	public void validateEntityBasic(T entity, List<MessageService> messages) {
		Class<?> classe = entity.getClass();

		for (Field field : classe.getDeclaredFields()) {
			if (field.isAnnotationPresent(Column.class)) {
				try {

					field.setAccessible(true);
					Object valueObj = field.get(entity);
					Column coluna = field.getAnnotation(Column.class);
					if (valueObj != null){
						String value = valueObj.toString(); 
						if ((coluna.nullable() == false) && value.trim() == "") {
							messages.add(new MessageService("INT0002",  coluna.columnDefinition() +" é um campo obrigatório", TypeMessageService.FATAL));
						}
						if ((coluna.length() > 0) && (value.length() > coluna.length())) {
							messages.add(new MessageService("INT0003", "O campo " + coluna.columnDefinition() + " pode ter no máximo " + coluna.length() + " caracteres.", TypeMessageService.FATAL));
						}
					}
				} catch (IllegalArgumentException e) {

					e.printStackTrace();

				} catch (IllegalAccessException e) {

					e.printStackTrace();
				}
			}
		}
	}
}
