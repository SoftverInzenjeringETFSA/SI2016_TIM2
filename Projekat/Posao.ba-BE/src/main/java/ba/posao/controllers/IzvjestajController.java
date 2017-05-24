package ba.posao.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ba.posao.models.Izvjestaj;
import ba.posao.repositories.OglasRepository;
import ba.posao.services.KorisnikService;
import ba.posao.services.NezaposleniService;
import ba.posao.services.OglasiPrijaveService;
import ba.posao.services.OglasiService;
import ba.posao.services.PoslodavacService;

@RestController
@CrossOrigin
@RequestMapping(path="/izvjestaj") 
public class IzvjestajController {

	
	@Autowired 
	NezaposleniService nezaposleniService;
	
	@Autowired 
	PoslodavacService poslodavacService;
	
	@Autowired 
	OglasiService oglasService;
	
	@Autowired
	OglasiPrijaveService oglasPrijaveService;
	
    @RequestMapping(path="", method = RequestMethod.GET)
    public Izvjestaj findAll() {
    
    	
    	Izvjestaj izvjestaj = new Izvjestaj();
    	
    	izvjestaj.setBrojNezaposlenih(nezaposleniService.getCount());
    	izvjestaj.setBrojOglasa(oglasService.getCount());
    	izvjestaj.setBrojPoslodavaca(poslodavacService.getCount());
    	izvjestaj.setBrojPrijava(oglasPrijaveService.getCount());
    	return izvjestaj;
    }
	
	
	
}
