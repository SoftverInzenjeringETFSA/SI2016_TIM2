package ba.posao.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ba.posao.models.Korisnici;
import ba.posao.services.KorisnikService;

@RestController
@RequestMapping(path="/korisnici")
public class KorisnikController {

	@Autowired
    private KorisnikService korisnikService;

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
