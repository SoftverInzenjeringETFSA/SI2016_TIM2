package ba.posao.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ba.posao.models.Kategorije;
import ba.posao.models.Korisnik;
import ba.posao.models.Nezaposleni;
import ba.posao.models.PasswordDTO;
import ba.posao.services.KorisnikService;
import ba.posao.services.NezaposleniService;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping(path="/korisnici")
public class KorisnikController {

	@Autowired
    private KorisnikService korisnikService;
	
	@Autowired
	private NezaposleniService nezaposleniService;
	
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity register(@RequestBody Korisnik korisnik)
    {
    	if (korisnik==null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Nemoguce kreirati praznog korisnika");
        try {
        	if(korisnik.getNezaposleni() != null)
        	{
        		korisnik.getNezaposleni().setKorisnici(korisnik);
                return korisnikService.registerKorisnik(korisnik);
                //korisnik.getNezaposleni().setKorisnici(korisnik);
                //return ResponseEntity.status(HttpStatus.OK)
                //        .body(nezaposleniService.registerNezaposleni(korisnik.getNezaposleni()));
        	}
        	else if (korisnik.getPoslodavac() != null)
        	{
        		korisnik.getPoslodavac().setKorisnici(korisnik);
                return korisnikService.registerKorisnik(korisnik);
        	} 
        	else return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        catch (ServiceException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                .body(e.getLocalizedMessage());
        }


    }
    //@PreAuthorize("hasAnyRole('ROLE_NEZAPOSLENI','ROLE_POSLODAVAC', 'ROLE_ADMIN')")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseEntity update(@RequestBody Korisnik korisnik,  @RequestParam(name="id")int id ) {
		
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Korisnik _korisnik = korisnikService.getKorisnikByUserName(auth.getName());
		
		if (_korisnik == null || _korisnik.getIdKorisnika() != korisnik.getIdKorisnika() || korisnik.getIdKorisnika() != id){
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Zabranjen pristup");
		}
    	
        try {
            return korisnikService.updateKorisnici(korisnik, id);
        }
        catch (ServiceException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                .body(e.getLocalizedMessage());
        }
    }


    @Autowired
    public void setKorisnikService(KorisnikService korisnikServis) {
        this.korisnikService = korisnikServis;
    }

    @RequestMapping(path="/get/all", method = RequestMethod.GET)
    public List<Korisnik> findAll() {
    	List<Korisnik> k;
    	
    	k = (List<Korisnik>) korisnikService.findAllKorisnici();
    	
    	return k;
    }

    @RequestMapping(path="/get", method = RequestMethod.GET)
    public List<Korisnik> viewKorisnici(@RequestParam(name = "id", defaultValue = "1") int id, @RequestParam(name = "p", defaultValue = "0") int pageNumber) {
    	List<Korisnik> k = new ArrayList<Korisnik>();
    	
    	if (pageNumber != 0)
    		k = (List<Korisnik>) korisnikService.getPage(pageNumber);
    	else
        	k.add(korisnikService.findKorisnici(id));
    	
    	return k;
    }
    
    
    @RequestMapping(path = "/delete", method = RequestMethod.DELETE)
    public ResponseEntity deleteKorisnici(@RequestParam(name = "id") int id) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Korisnik _korisnik = korisnikService.getKorisnikByUserName(auth.getName());	
		if (_korisnik == null || _korisnik.getIdKorisnika() != id){
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Zabranjen pristup");
		}
		
		return korisnikService.removeKorisnici(id);
		
		/*
		String passMD5=korisnikService.toMD5(pass.getPassword());
		if (passMD5.equals(_korisnik.getPassword()))
		{
			return korisnikService.removeKorisnici(id);
		}
		else return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Pogresan password");
		*/
    }
    
    @RequestMapping(path="/tip", method = RequestMethod.GET) 
    public String tipKorisnika(@RequestParam(name = "id") int id) {
    	return korisnikService.getKorisnikType(id);
    }
    
    @RequestMapping(path="", method = RequestMethod.GET) 
    public List<Korisnik> searchByName(@RequestParam(name = "name") String name) {
    	return korisnikService.findByName(name);
    }
    
  
    @PreAuthorize("#name == authentication.name")
    @RequestMapping(path="/get/exact", method = RequestMethod.GET) 
    public Korisnik searchByUsername(@RequestParam(name = "name") String name) {
    	return korisnikService.getKorisnikByUserName(name);
    }
    
    @RequestMapping(path="/nezaposleni", method = RequestMethod.GET) 
    public Iterable<Nezaposleni> getNezaposleni() {
    	return nezaposleniService.getAll();
    }
    
    
    
}
