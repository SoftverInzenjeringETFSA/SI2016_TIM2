package ba.posao.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ba.posao.models.Kategorije;
import ba.posao.models.Lokacije;
import ba.posao.models.Template;
import ba.posao.services.KategorijeService;
import ba.posao.services.LokacijeService;


@RestController
@CrossOrigin
@RequestMapping(path="/lokacije") 
public class LokacijeController {
	
	@Autowired	
    private LokacijeService lokacijeService;
	
	@CrossOrigin
    @RequestMapping(path="/get/all", method = RequestMethod.GET)
    public List<Lokacije> findAll() {
    	List<Lokacije> k;
    	
    	k = (List<Lokacije>) lokacijeService.findAllLokacije();
    	
    	return k;
    }
}
