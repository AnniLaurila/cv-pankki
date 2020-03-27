package com.example.cvpankki.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Projekti {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long projektiId;
	private String projektinimi;
	private String tehtava;
	private String asiakas;
	private int alkukk;
	private int alkuvuosi;
	private int paattymiskk;
	private int paattymisvuosi;
	private String avainsanat;
	
	@ManyToOne
	@JsonManagedReference
	@JoinColumn(name = "henkiloId")
	private Henkilo henkilo;
	
}
