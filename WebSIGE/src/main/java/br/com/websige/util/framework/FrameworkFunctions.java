package br.com.websige.util.framework;

import java.lang.reflect.Field;

import br.com.websige.pattern.GenericEntity;

public class FrameworkFunctions {
	public static boolean checkEmpty(GenericEntity entity) {

		Class<?> classe = entity.getClass();

		for (Field field : classe.getDeclaredFields()) {
			try {
				field.setAccessible(true);
				if (field.getName()!= "serialVersionUID"){
					Object valueObj = field.get(entity);
					if (valueObj != null) {
						if (!valueObj.toString().equals("")) {
							return false;
						}
					}
				}
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return true;
	}
}
