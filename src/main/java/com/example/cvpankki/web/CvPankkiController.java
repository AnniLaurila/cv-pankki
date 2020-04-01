package com.example.cvpankki.web;

import java.security.Principal;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.cvpankki.domain.Henkilo;
import com.example.cvpankki.domain.HenkiloRepository;
import com.example.cvpankki.domain.ProjektiRepository;
import com.example.cvpankki.domain.SertifikaattiRepository;
import com.example.cvpankki.domain.TeknologiaosaaminenRepository;
import com.example.cvpankki.domain.User;
import com.example.cvpankki.domain.UserRepository;

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
	@Autowired
	private UserRepository uRepository;
	
	
	@RequestMapping(value= {"/", "/index"}, method=RequestMethod.GET)
    public String naytaOmatTiedot(Model model, HttpServletRequest request) {
		
		//haetaan kirjautuneen käyttäjän tiedot
		Principal principal = request.getUserPrincipal();
		User user = uRepository.findByUsername(principal.getName());
		Optional<Henkilo> henkilo = hRepository.findById(user.getHenkiloId());
		model.addAttribute("henkilo", henkilo.get());
		model.addAttribute("teknologiat", henkilo.get().getTeknologiaosaaminen());
		model.addAttribute("sertifikaatit", henkilo.get().getSertifikaatit());
		
        return "omattiedot";
    }
	
	
	

}
