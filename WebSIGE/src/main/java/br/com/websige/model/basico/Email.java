package br.com.websige.model.basico;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.websige.pattern.GenericEntity;

@Entity
@Table(name="EMAIL_EMA")
public class Email extends GenericEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "EMA_EMAIL", nullable = false, length = 255)
	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
