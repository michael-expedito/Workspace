package br.com.websige.pattern;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class GenericEntity<T> {

	public Long getId() {
		return null;
	}

	public void setId(Long id) {
		
	}
}
