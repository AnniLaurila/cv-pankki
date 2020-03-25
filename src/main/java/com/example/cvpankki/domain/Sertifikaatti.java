package com.example.cvpankki.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Sertifikaatti {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long sertifikaattiId;
	private String sertifikaatinNimi;
	private String myontaja;
	private int vuosi;
	
	@ManyToOne
	@JsonManagedReference
	@JoinColumn(name = "henkiloId")
	private Henkilo henkilo;
	
}
