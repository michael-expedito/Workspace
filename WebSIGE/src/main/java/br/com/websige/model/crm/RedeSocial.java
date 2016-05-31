package br.com.websige.model.crm;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.websige.pattern.GenericEntity;

@Entity
@Table(name="REDESOCIAL_RSO")
public class RedeSocial extends GenericEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "RSO_FACEBOOK", nullable = true, length = 255)
	private String facebook;
	
	@Column(name = "RSO_TWITTER", nullable = true, length = 255)
	private String twitter;
	
	@Column(name = "RSO_LINKEDIN", nullable = true, length = 255)
	private String linkedIn;
	
	@Column(name = "RSO_SKYPE", nullable = true, length = 255)
	private String skype;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public String getTwitter() {
		return twitter;
	}

	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}

	public String getLinkedIn() {
		return linkedIn;
	}

	public void setLinkedIn(String linkedIn) {
		this.linkedIn = linkedIn;
	}

	public String getSkype() {
		return skype;
	}

	public void setSkype(String skype) {
		this.skype = skype;
	}
}
