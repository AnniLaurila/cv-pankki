package com.example.cvpankki.web;

import java.security.Principal;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.cvpankki.domain.Henkilo;
import com.example.cvpankki.domain.HenkiloRepository;
import com.example.cvpankki.domain.ProjektiRepository;
import com.example.cvpankki.domain.SertifikaattiRepository;
import com.example.cvpankki.domain.Teknologiaosaaminen;
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

	@RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
	public String naytaOmatTiedot(Model model, HttpServletRequest request) {

		Henkilo henkilo = haeKirjautunutKayttaja(request);
		model.addAttribute("henkilo", henkilo);
		model.addAttribute("teknologiat", henkilo.getTeknologiaosaaminen());
		model.addAttribute("sertifikaatit", henkilo.getSertifikaatit());

		return "omattiedot";
	}

	@RequestMapping(value = { "/muokkaa" }, method = RequestMethod.GET)
	public String muokkaaOmiaTietoja(Model model, HttpServletRequest request) {

		Henkilo henkilo = haeKirjautunutKayttaja(request);
		model.addAttribute("henkilo", henkilo);

		return "muokkaa";
	}

	@RequestMapping(value = "/tallennaOmatTiedot", method = RequestMethod.POST)
	public String tallenna(Henkilo henkilo) {
		hRepository.save(henkilo);
		return "redirect:/";
	}

	@RequestMapping(value = { "/teknologiaosaaminen" }, method = RequestMethod.GET)
	public String muokkaaTeknologiaosaamista(Model model, HttpServletRequest request) {

		Henkilo henkilo = haeKirjautunutKayttaja(request);
		model.addAttribute("henkilo", henkilo);
		model.addAttribute("teknologiaosaaminen", new Teknologiaosaaminen());
		return "teknologiaosaaminen";
	}

	@RequestMapping(value = "/tallennaTeknologia", method = RequestMethod.POST)
	public String tallennaTeknologia(Teknologiaosaaminen teknologiaosaaminen, HttpServletRequest request) {

		Henkilo henkilo = haeKirjautunutKayttaja(request);
		teknologiaosaaminen.setHenkilo(henkilo);
		toRepository.save(teknologiaosaaminen);
		return "redirect:/teknologiaosaaminen";
	}
	
	@RequestMapping(value="/poistaTeknologia/{id}", method=RequestMethod.GET)
	public String poistaTeknologia(@PathVariable("id") Long teknologiaOsaaminenId, Model model) {
		toRepository.deleteById(teknologiaOsaaminenId);
		return "redirect:../teknologiaosaaminen";
	}
	

	private Henkilo haeKirjautunutKayttaja(HttpServletRequest request) {
		// haetaan kirjautuneen käyttäjän tiedot
		Principal principal = request.getUserPrincipal();
		User user = uRepository.findByUsername(principal.getName());
		Optional<Henkilo> henkilo = hRepository.findById(user.getHenkiloId());
		return henkilo.get();
	}

}
