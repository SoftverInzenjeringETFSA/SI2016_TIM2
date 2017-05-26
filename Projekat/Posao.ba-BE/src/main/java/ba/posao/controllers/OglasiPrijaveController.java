package ba.posao.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ba.posao.models.Korisnik;
import ba.posao.services.KorisnikService;
import ba.posao.services.OglasiPrijaveService;

@Controller    
@RequestMapping(path="/prijave") 
public class OglasiPrijaveController {
	
	@Autowired
	OglasiPrijaveService service;
	
	@Autowired
	KorisnikService korisnikService;
	
	 @CrossOrigin
	  @RequestMapping(value = "/add", method = RequestMethod.POST)
	  public ResponseEntity register(@RequestParam(name="korisnik")int k_id, @RequestParam(name="oglas")int o_id)
	  {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			Korisnik _korisnik = korisnikService.getKorisnikByUserName(auth.getName());	
			if (_korisnik == null || _korisnik.getIdKorisnika() != k_id){
				return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Zabranjen pristup");
			}			
			return ResponseEntity.status(HttpStatus.OK).body(service.addPrijavu(k_id, o_id));
	  }
	 
	 @CrossOrigin
	  @RequestMapping(value = "", method = RequestMethod.GET)
	  public ResponseEntity prijavljen(@RequestParam(name="korisnik")int k_id, @RequestParam(name="oglas")int o_id)
	  {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			Korisnik _korisnik = korisnikService.getKorisnikByUserName(auth.getName());	
			if (_korisnik == null || _korisnik.getIdKorisnika() != k_id){
				return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Zabranjen pristup");
			}	

			return service.imaPrijava(k_id, o_id);
	  } 
}
