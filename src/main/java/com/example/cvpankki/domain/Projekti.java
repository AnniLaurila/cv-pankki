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
public class Projekti {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "projekti_id")
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
