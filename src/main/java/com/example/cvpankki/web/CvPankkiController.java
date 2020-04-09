package com.example.cvpankki.web;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.cvpankki.auth.UserService;
import com.example.cvpankki.auth.UserValidator;
import com.example.cvpankki.domain.Henkilo;
import com.example.cvpankki.domain.HenkiloRepository;
import com.example.cvpankki.domain.Projekti;
import com.example.cvpankki.domain.ProjektiRepository;
import com.example.cvpankki.domain.Sertifikaatti;
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
	
    @Autowired
    private UserValidator userValidator;
    @Autowired
    private UserService userService;

	@RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
	public String naytaOmatTiedot(Model model, HttpServletRequest request) {

		Henkilo henkilo = haeKirjautunutKayttaja(request);
		model.addAttribute("henkilo", henkilo);
		model.addAttribute("teknologiat", henkilo.getTeknologiaosaaminen());
		model.addAttribute("sertifikaatit", henkilo.getSertifikaatit());
		model.addAttribute("projektit", henkilo.getProjektit());

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
		//tarkistus, että käyttäjä tallentaa omia tietojaan?
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
	
	@RequestMapping(value = { "/sertifikaatit" }, method = RequestMethod.GET)
	public String muokkaaSerifikaatteja(Model model, HttpServletRequest request) {

		Henkilo henkilo = haeKirjautunutKayttaja(request);
		model.addAttribute("henkilo", henkilo);
		model.addAttribute("sertifikaatti", new Sertifikaatti());
		return "sertifikaatit";
	}
	
	@RequestMapping(value = "/tallennaSertifikaatti", method = RequestMethod.POST)
	public String tallennaSertifikaatti(Sertifikaatti sertifikaatti, HttpServletRequest request) {

		Henkilo henkilo = haeKirjautunutKayttaja(request);
		sertifikaatti.setHenkilo(henkilo);
		sRepository.save(sertifikaatti);
		return "redirect:/sertifikaatit";
	}
	
	@RequestMapping(value="/poistaSertifikaatti/{id}", method=RequestMethod.GET)
	public String poistaSertifikaatti(@PathVariable("id") Long sertifikaattiId, Model model) {
		
		sRepository.deleteById(sertifikaattiId);
		return "redirect:../sertifikaatit";
	}
	
	@RequestMapping(value = { "/projektit" }, method = RequestMethod.GET)
	public String muokkaaProjektikokemusta(Model model, HttpServletRequest request) {

		Henkilo henkilo = haeKirjautunutKayttaja(request);
		model.addAttribute("henkilo", henkilo);
		model.addAttribute("projekti", new Projekti());
		return "projektit";
	}

	@RequestMapping(value = "/tallennaProjekti", method = RequestMethod.POST)
	public String tallennaProjekti(Projekti projekti, HttpServletRequest request) {

		Henkilo henkilo = haeKirjautunutKayttaja(request);
		projekti.setHenkilo(henkilo);
		pRepository.save(projekti);
		return "redirect:/projektit";
	}
	
	@RequestMapping(value="/poistaProjekti/{id}", method=RequestMethod.GET)
	public String poistaProjekti(@PathVariable("id") Long projektiId, Model model) {
		
		pRepository.deleteById(projektiId);
		return "redirect:../projektit";
	}
	
	//vain admin-roolin omaavalla on oikeus selata kaikkien työtekijöiden CV:itä
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = { "/henkiloListaus" }, method = RequestMethod.GET)
	public String naytaKaikkiCVt(Model model, HttpServletRequest request) {

		model.addAttribute("henkilot", hRepository.findAll());
		return "henkilolistaus";
	}
	
	// REST kaikkien työntekijöiden hakuun
    @RequestMapping(value="/henkilot")
    public @ResponseBody List<Henkilo> findHenkilotRest() {	
        return (List<Henkilo>) hRepository.findAll();
    }    
    
	// REST yksittäisen työntekijän tietojen hakuun
    @RequestMapping(value="/henkilo/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Henkilo> findHenkiloRest(@PathVariable("id") Long henkiloId) {	
    	return hRepository.findById(henkiloId);
    } 
	
    
	@RequestMapping(value = { "/vaihdasalasana" }, method = RequestMethod.GET)
	public String vaihdaSalasana(Model model, HttpServletRequest request) {

		Principal principal = request.getUserPrincipal();
		User user = uRepository.findByUsername(principal.getName());
		model.addAttribute("user", user);
		return "vaihdasalasana";
	}
	
	@RequestMapping(value = "/tallennaSalasana", method = RequestMethod.POST)
	public String tallennaSalasana(@ModelAttribute User user, BindingResult bindingResult, 
			HttpServletRequest request) {
		
		user.setHenkiloId(haeKirjautunutKayttaja(request).getHenkiloId());
        userValidator.validate(user, bindingResult);

        if (bindingResult.hasErrors()) {
            return "vaihdasalasana";
        }

        user.setHenkiloId(haeKirjautunutKayttaja(request).getHenkiloId());
        userService.save(user);
        return "redirect:/";
	}	
    
    
	private Henkilo haeKirjautunutKayttaja(HttpServletRequest request) {

		Principal principal = request.getUserPrincipal();
		User user = uRepository.findByUsername(principal.getName());
		Optional<Henkilo> henkilo = hRepository.findById(user.getHenkiloId());
		return henkilo.get();
	}

}
