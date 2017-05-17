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

import ba.posao.models.Korisnici;
import ba.posao.services.KorisnikService;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity register(@RequestBody Korisnici korisnik)
    {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(korisnikService.registerKorisnik(korisnik));
        }
        catch (ServiceException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                .body(e.getLocalizedMessage());
        }


    }
    @PreAuthorize("hasAnyRole('ROLE_NEZAPOSLENI','ROLE_POSLODAVAC', 'ROLE_ADMIN')")
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity update(@RequestBody Korisnici korisnik ) {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                                .body(korisnikService.updateKorisnici(korisnik));
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
    public List<Korisnici> findAll() {
    	List<Korisnici> k;
    	
    	k = (List<Korisnici>) korisnikService.findAllKorisnici();
    	
    	return k;
    }

    @RequestMapping(path="/get", method = RequestMethod.GET)
    public List<Korisnici> viewKorisnici(@RequestParam(name = "id", defaultValue = "1") int id, @RequestParam(name = "p", defaultValue = "0") int pageNumber) {
    	List<Korisnici> k = new ArrayList<Korisnici>();
    	
    	if (pageNumber != 0)
    		k = (List<Korisnici>) korisnikService.getPage(pageNumber);
    	else
        	k.add(korisnikService.findKorisnici(id));
    	
    	return k;
    }
    
    @RequestMapping(path= "/add", method = RequestMethod.GET)
	public String addKorisnici(@ModelAttribute("imeForme") Korisnici k){
		
		if(k.getIdKorisnika() == 0) {
			korisnikService.addKorisnici(k);
		}
		else {
			korisnikService.updateKorisnici(k);
		}
		
		return "done";
	}
    
    @RequestMapping(path = "/delete", method = RequestMethod.GET)
    public String deleteKorisnici(@RequestParam(name = "id") int id) {
    	
    	korisnikService.removeKorisnici(id);
        return "obavljeno";
    }
    
    @RequestMapping(path="/tip", method = RequestMethod.GET) 
    public String tipKorisnika(@RequestParam(name = "id") int id) {
    	return korisnikService.getKorisnikType(id);
    }


}
