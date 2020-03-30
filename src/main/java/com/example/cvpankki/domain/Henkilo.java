package com.example.cvpankki.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "henkilo")
public class Henkilo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "henkilo_id")
	private Long henkiloId;
	private String etunimi;
	private String sukunimi;
	private String puhelin;
	private String email;
	@Column(name = "tehtavanimike")
	private String tehtavaNimike;
	private String kuvaus;
	private String oppiarvo;
	private String oppilaitos;
	private int valmistumisvuosi;
	@Column(name = "onkokaytettavissa")
	boolean onkoKaytettavissa;
	
	@JsonBackReference
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "henkilo")
	private List<Teknologiaosaaminen> teknologiaosaaminen;
	
	@JsonBackReference
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "henkilo")
	private List<Sertifikaatti> sertifikaatit;

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

	public String getTehtavaNimike() {
		return tehtavaNimike;
	}

	public void setTehtavaNimike(String tehtavaNimike) {
		this.tehtavaNimike = tehtavaNimike;
	}

	public String getKuvaus() {
		return kuvaus;
	}

	public void setKuvaus(String kuvaus) {
		this.kuvaus = kuvaus;
	}

	public String getOppiarvo() {
		return oppiarvo;
	}

	public void setOppiarvo(String oppiarvo) {
		this.oppiarvo = oppiarvo;
	}

	public String getOppilaitos() {
		return oppilaitos;
	}

	public void setOppilaitos(String oppilaitos) {
		this.oppilaitos = oppilaitos;
	}

	public int getValmistumisvuosi() {
		return valmistumisvuosi;
	}

	public void setValmistumisvuosi(int valmistumisvuosi) {
		this.valmistumisvuosi = valmistumisvuosi;
	}

	public boolean isOnkoKaytettavissa() {
		return onkoKaytettavissa;
	}

	public void setOnkoKaytettavissa(boolean onkoKaytettavissa) {
		this.onkoKaytettavissa = onkoKaytettavissa;
	}

	public List<Teknologiaosaaminen> getTeknologiaosaaminen() {
		return teknologiaosaaminen;
	}

	public void setTeknologiaosaaminen(List<Teknologiaosaaminen> teknologiaosaaminen) {
		this.teknologiaosaaminen = teknologiaosaaminen;
	}

	public List<Sertifikaatti> getSertifikaatit() {
		return sertifikaatit;
	}

	public void setSertifikaatit(List<Sertifikaatti> sertifikaatit) {
		this.sertifikaatit = sertifikaatit;
	}
	
	
	


}
