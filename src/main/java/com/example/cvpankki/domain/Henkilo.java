package com.example.cvpankki.domain;

import java.util.Collections;
import java.util.Comparator;
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

	@JsonBackReference
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "henkilo")
	private List<Projekti> projektit;
	
	public Henkilo() {}
	
	public Henkilo(String etunimi, String sukunimi, String puhelin, String email, String tehtavaNimike, String kuvaus,
			String oppiarvo, String oppilaitos, int valmistumisvuosi, boolean onkoKaytettavissa,
			List<Teknologiaosaaminen> teknologiaosaaminen, List<Sertifikaatti> sertifikaatit,
			List<Projekti> projektit) {

		this.etunimi = etunimi;
		this.sukunimi = sukunimi;
		this.puhelin = puhelin;
		this.email = email;
		this.tehtavaNimike = tehtavaNimike;
		this.kuvaus = kuvaus;
		this.oppiarvo = oppiarvo;
		this.oppilaitos = oppilaitos;
		this.valmistumisvuosi = valmistumisvuosi;
		this.onkoKaytettavissa = onkoKaytettavissa;
		this.teknologiaosaaminen = teknologiaosaaminen;
		this.sertifikaatit = sertifikaatit;
		this.projektit = projektit;
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
		
		//sortataan teknologiaosaaminen ajallisen kokemuksen mukaan suurimmasta pienimpään
		Collections.sort(teknologiaosaaminen, Comparator.comparing(Teknologiaosaaminen::getVuodet)
	            .thenComparing(Teknologiaosaaminen::getKuukaudet));
		Collections.reverse(teknologiaosaaminen);
		return teknologiaosaaminen;
	}

	public void setTeknologiaosaaminen(List<Teknologiaosaaminen> teknologiaosaaminen) {
		this.teknologiaosaaminen = teknologiaosaaminen;
	}

	public List<Sertifikaatti> getSertifikaatit() {
		//sortataan sertifikaatit aina myöntämisvuoden mukaan
		Collections.sort(sertifikaatit);
		return sertifikaatit;
	}

	public void setSertifikaatit(List<Sertifikaatti> sertifikaatit) {
		this.sertifikaatit = sertifikaatit;
	}

	public List<Projekti> getProjektit() {
		//sortataan projekit aina alkuvuoden mukaan
		Collections.sort(projektit);
		return projektit;
	}

	public void setProjektit(List<Projekti> projektit) {
		this.projektit = projektit;
	}
	
	
	


}
