package ba.posao.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ba.posao.models.Izvjestaj;
import ba.posao.models.Korisnik;
import ba.posao.models.Korisnik;
import ba.posao.repositories.KorisnikRepository;
import ba.posao.repositories.OglasRepository;
import ba.posao.services.KorisnikService;

@RestController
@CrossOrigin
@RequestMapping(path="/izvjestaj") 
public class IzvjestajController {

	@Autowired
	private KorisnikService korisnikService;
	
	@Autowired
	private OglasRepository oglasRepository;
	
    @RequestMapping(path="/get", method = RequestMethod.GET)
    public Izvjestaj findAll() {
    	List<Korisnik> korisnici;
    	
    	Izvjestaj izvjestaj = new Izvjestaj();
    	
    	korisnici = (List<Korisnik>) korisnikService.findAllKorisnici();
    	izvjestaj.setBrojKorisnika(korisnici.size());
    	izvjestaj.setBrojUspjesnihOglasa(oglasRepository.brojUspjesnihPrijava());
    	izvjestaj.setBrojOglasa(oglasRepository.findAll().size());
    	
    	return izvjestaj;
    }
	
	
	
}
