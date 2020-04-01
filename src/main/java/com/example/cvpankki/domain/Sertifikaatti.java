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
@Table(name = "sertifikaatti")
public class Sertifikaatti {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "sertifikaatti_id")
	private Long sertifikaattiId;
	@Column(name = "nimi")
	private String sertifikaatinNimi;
	private String myontaja;
	private int vuosi;
	
	@ManyToOne
	@JsonManagedReference
	@JoinColumn(name = "henkilo_id")
	private Henkilo henkilo;

	public Long getSertifikaattiId() {
		return sertifikaattiId;
	}

	public void setSertifikaattiId(Long sertifikaattiId) {
		this.sertifikaattiId = sertifikaattiId;
	}

	public String getSertifikaatinNimi() {
		return sertifikaatinNimi;
	}

	public void setSertifikaatinNimi(String sertifikaatinNimi) {
		this.sertifikaatinNimi = sertifikaatinNimi;
	}

	public String getMyontaja() {
		return myontaja;
	}

	public void setMyontaja(String myontaja) {
		this.myontaja = myontaja;
	}

	public int getVuosi() {
		return vuosi;
	}

	public void setVuosi(int vuosi) {
		this.vuosi = vuosi;
	}

	public Henkilo getHenkilo() {
		return henkilo;
	}

	public void setHenkilo(Henkilo henkilo) {
		this.henkilo = henkilo;
	}
	
	
}
