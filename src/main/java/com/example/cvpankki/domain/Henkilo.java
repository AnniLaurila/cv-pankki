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
	private String etunimi;
	private String sukunimi;
	private String puhelin;
	private String email;
	 
	public Henkilo() {};
	 
	public Henkilo(String etunimi, String sukunimi, String puhelin, String email) {
		this.etunimi = etunimi;
		this.sukunimi = sukunimi;
		this.puhelin = puhelin;
		this.email = email;
	}

	public Long getHenkiloId() {
		return henkiloId;
	}

	public void setHenkiloId(Long henkiloId) {
		this.henkiloId = henkiloId;
	}

	public String getEtunimi() {
		return etunimi;
	}

	public void setEtunimi(String etunimi) {
		this.etunimi = etunimi;
	}

	public String getSukunimi() {
		return sukunimi;
	}

	public void setSukunimi(String sukunimi) {
		this.sukunimi = sukunimi;
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
		return "Henkilo [henkiloId=" + henkiloId + ", etunimi=" + etunimi + ", sukunimi=" + sukunimi + ", puhelin="
				+ puhelin + ", email=" + email + "]";
	}

}
