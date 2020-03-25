package com.example.cvpankki.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Teknologiaosaaminen {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long teknologiaosaaminenId;
	private String teknologia;
	private int vuodet;
	private int kuukaudet;
	
	@ManyToOne
	@JsonManagedReference
	@JoinColumn(name = "henkiloId")
	private Henkilo henkilo;
	

}
