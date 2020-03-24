package com.example.cvpankki.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Henkilo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long henkiloId;
	private String puhelin;
	private String email;
	 
	public Henkilo() {};
	 
	public Henkilo(String puhelin, String email) {
		this.puhelin = puhelin;
		this.email = email;
	}

	public Long getHenkiloId() {
		return henkiloId;
	}

	public void setHenkiloId(Long henkiloId) {
		this.henkiloId = henkiloId;
	}

	public String getPuhelin() {
		return puhelin;
	}

	public void setPuhelin(String puhelin) {
		this.puhelin = puhelin;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Henkilo [henkiloId=" + henkiloId + ", puhelin=" + puhelin + ", email=" + email + "]";
	}
	 

}
