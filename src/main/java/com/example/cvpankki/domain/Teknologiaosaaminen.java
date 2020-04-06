package com.example.cvpankki.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "teknologiaosaaminen")
public class Teknologiaosaaminen {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "teknologia_id")
	private Long teknologiaosaaminenId;
	private String teknologia;
	private int vuodet;
	private int kuukaudet;
	
	@ManyToOne
	@JsonManagedReference
	@JoinColumn(name = "henkilo_id")
	private Henkilo henkilo;

	public Long getTeknologiaosaaminenId() {
		return teknologiaosaaminenId;
	}

	public void setTeknologiaosaaminenId(Long teknologiaosaaminenId) {
		this.teknologiaosaaminenId = teknologiaosaaminenId;
	}

	public String getTeknologia() {
		return teknologia;
	}

	public void setTeknologia(String teknologia) {
		this.teknologia = teknologia;
	}

	public int getVuodet() {
		return vuodet;
	}

	public void setVuodet(int vuodet) {
		this.vuodet = vuodet;
	}

	public int getKuukaudet() {
		return kuukaudet;
	}

	public void setKuukaudet(int kuukaudet) {
		this.kuukaudet = kuukaudet;
	}

	public Henkilo getHenkilo() {
		return henkilo;
	}

	public void setHenkilo(Henkilo henkilo) {
		this.henkilo = henkilo;
	}

    
}
