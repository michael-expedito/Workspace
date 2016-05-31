package br.com.websige.model.seguranca;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.websige.pattern.GenericEntity;

@Entity
@Table(name = "USUARIO_USU")
public class Usuario extends GenericEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
}
