package ba.posao.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ba.posao.models.Notifikacija;
import ba.posao.services.NotifikacijaService;

@RestController
@CrossOrigin
@RequestMapping(path="/notifikacije") 
public class NotifikacijaController {
	
	@Autowired	
    private NotifikacijaService notifikacijaService;
	
	@GetMapping(path="/{id}")
	public @ResponseBody Notifikacija getNotifikacijaById(@PathVariable("id") Integer id) {
		return notifikacijaService.findByIdNotifikacije(id);
	}
	
    @RequestMapping(path="/get/all", method = RequestMethod.GET)
    public List<Notifikacija> findAll() {
    	List<Notifikacija> n;
    	
    	n = (List<Notifikacija>) notifikacijaService.findAllNotifikacija();
    	
    	return n;
    }
    
    @RequestMapping(path="/get", method = RequestMethod.GET)
    public List<Notifikacija> viewNotifikacija(@RequestParam(name = "id", defaultValue = "1") int id, @RequestParam(name = "p", defaultValue = "0") int pageNumber) {
    	List<Notifikacija> n = new ArrayList<Notifikacija>();
    	
    	if (pageNumber != 0)
    		n = (List<Notifikacija>) notifikacijaService.getPage(pageNumber);
    	else
        	n.add(notifikacijaService.findNotifikacija(id));
    	
    	return n;
    }
    
    @RequestMapping(path= "/add", method = RequestMethod.GET)
	public String addNotifikacija(@ModelAttribute("imeForme") Notifikacija n){
		
		if(n.getIdNotifikacije() == 0) {
			notifikacijaService.addNotifikacija(n);
		}
		else {
			notifikacijaService.updateNotifikacija(n);
		}
		
		return "done";
	}
    
    @RequestMapping(path = "/delete", method = RequestMethod.GET)
    public String deleteNotifikacija(@RequestParam(name = "id") int id) {
    	
    	notifikacijaService.removeNotifikacija(id);
        return "obavljeno";
    }

}
