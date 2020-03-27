package com.example.cvpankki.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.cvpankki.domain.HenkiloRepository;
import com.example.cvpankki.domain.ProjektiRepository;
import com.example.cvpankki.domain.SertifikaattiRepository;
import com.example.cvpankki.domain.TeknologiaosaaminenRepository;

@Controller

public class CvPankkiController {
	
	@Autowired
	private HenkiloRepository hRepository;
	@Autowired
	private TeknologiaosaaminenRepository toRepository;
	@Autowired
	private SertifikaattiRepository sRepository;
	@Autowired
	private ProjektiRepository pRepository;
	
	
	@RequestMapping(value= {"/", "/index"}, method=RequestMethod.GET)
    public String naytaOmatTiedot(Model model) {
		
		//haetaan henkilön omat tiedot
        model.addAttribute("attribuutti", "Omat tiedot");
        return "omattiedot";
    }
	
	
	

}
