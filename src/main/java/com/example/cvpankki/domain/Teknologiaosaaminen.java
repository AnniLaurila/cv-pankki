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
@Table(name = "teknologiaosaaminen")
public class Teknologiaosaaminen {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "teknologia_id")
	private Long teknologiaosaaminenId;
	private String teknologia;
	private int vuodet;
	private int kuukaudet;
	
	@ManyToOne
	@JsonManagedReference
	@JoinColumn(name = "henkiloId")
	private Henkilo henkilo;
	

}
