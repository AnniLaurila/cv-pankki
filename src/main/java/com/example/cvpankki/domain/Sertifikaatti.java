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
	@JoinColumn(name = "henkiloId")
	private Henkilo henkilo;
	
}
