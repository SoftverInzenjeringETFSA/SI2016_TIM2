package ba.posao.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ba.posao.models.Korisnik;
import ba.posao.models.Lokacije;
import ba.posao.models.PorukaDTO;
import ba.posao.models.Poruke;
import ba.posao.repositories.PorukeRepository;
import ba.posao.services.KorisnikService;
import ba.posao.services.PorukeService;

@Controller    // This means that this class is a Controller. no shit??
@CrossOrigin
@RequestMapping(path="/poruke") 
public class PorukeController {
	
	@Autowired
	PorukeService service;

	@Autowired
	KorisnikService korisnikService;

	
	@CrossOrigin
    @RequestMapping(path="/get/sender", method = RequestMethod.GET)
    public  ResponseEntity findS(@RequestParam("sender") int id) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Korisnik _korisnik = korisnikService.getKorisnikByUserName(auth.getName());	
		if (_korisnik == null || _korisnik.getIdKorisnika() != id){
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Zabranjen pristup");
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(service.getMessagesBySender(id));
	}
	
	@CrossOrigin
    @RequestMapping(path="/get", method = RequestMethod.GET)
    public  ResponseEntity findR(@RequestParam("recipient") int id) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Korisnik _korisnik = korisnikService.getKorisnikByUserName(auth.getName());	
		if (_korisnik == null || _korisnik.getIdKorisnika() != id){
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Zabranjen pristup");
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(service.getMessagesByRecipient(id));
	}
	
	@CrossOrigin
    @RequestMapping(path="/send", method = RequestMethod.POST)
    public  ResponseEntity findAll(@RequestBody PorukaDTO poruka) {
	
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Korisnik _korisnik = korisnikService.getKorisnikByUserName(auth.getName());	
		if (_korisnik == null || _korisnik.getIdKorisnika() != poruka.getPosiljalac()){
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Zabranjen pristup");
		}

		return ResponseEntity.ok(service.sendMssg(poruka));
		
	}
}
