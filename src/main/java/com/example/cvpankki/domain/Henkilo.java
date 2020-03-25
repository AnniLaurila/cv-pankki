package com.example.cvpankki.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Henkilo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long henkiloId;
	private String etunimi;
	private String sukunimi;
	private String puhelin;
	private String email;
	private String tehtavaNimike;
	private String kuvaus;
	private String oppiarvo;
	private String oppilaitos;
	private int valmistumisvuosi;
	boolean onkoKaytettavissa;
	
	@JsonBackReference
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "teknologiaosaaminen")
	private List<Teknologiaosaaminen> teknologiaosaaminen;
	
	
	
	 


}
