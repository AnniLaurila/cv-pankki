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
@Table(name = "projekti")
public class Projekti implements Comparable<Projekti> {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "projekti_id")
    private Long projektiId;
	private String projektinimi;
	private String tehtava;
	private String asiakas;
	private int alkukk;
	private Integer alkuvuosi;
	private int paattymiskk;
	private int paattymisvuosi;
	private String avainsanat;
	
	@ManyToOne
	@JsonManagedReference
	@JoinColumn(name = "henkilo_id")
	private Henkilo henkilo;

	public Long getProjektiId() {
		return projektiId;
	}

	public void setProjektiId(Long projektiId) {
		this.projektiId = projektiId;
	}

	public String getProjektinimi() {
		return projektinimi;
	}

	public void setProjektinimi(String projektinimi) {
		this.projektinimi = projektinimi;
	}

	public String getTehtava() {
		return tehtava;
	}

	public void setTehtava(String tehtava) {
		this.tehtava = tehtava;
	}

	public String getAsiakas() {
		return asiakas;
	}

	public void setAsiakas(String asiakas) {
		this.asiakas = asiakas;
	}

	public int getAlkukk() {
		return alkukk;
	}

	public void setAlkukk(int alkukk) {
		this.alkukk = alkukk;
	}

	public Integer getAlkuvuosi() {
		return alkuvuosi;
	}

	public void setAlkuvuosi(Integer alkuvuosi) {
		this.alkuvuosi = alkuvuosi;
	}

	public int getPaattymiskk() {
		return paattymiskk;
	}

	public void setPaattymiskk(int paattymiskk) {
		this.paattymiskk = paattymiskk;
	}

	public int getPaattymisvuosi() {
		return paattymisvuosi;
	}

	public void setPaattymisvuosi(int paattymisvuosi) {
		this.paattymisvuosi = paattymisvuosi;
	}

	public String getAvainsanat() {
		return avainsanat;
	}

	public void setAvainsanat(String avainsanat) {
		this.avainsanat = avainsanat;
	}

	public Henkilo getHenkilo() {
		return henkilo;
	}

	public void setHenkilo(Henkilo henkilo) {
		this.henkilo = henkilo;
	}

    @Override
    public int compareTo(Projekti p) {
        return this.getAlkuvuosi().compareTo(p.getAlkuvuosi());
    }
	
	
}
