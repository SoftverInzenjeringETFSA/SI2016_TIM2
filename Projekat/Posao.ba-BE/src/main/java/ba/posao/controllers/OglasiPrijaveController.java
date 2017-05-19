package ba.posao.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ba.posao.services.OglasiPrijaveService;

@Controller    
@RequestMapping(path="/prijave") 
public class OglasiPrijaveController {
	
	@Autowired
	OglasiPrijaveService service;
	
	 @CrossOrigin
	  @RequestMapping(value = "/add", method = RequestMethod.POST)
	  public ResponseEntity register(@RequestParam(name="korisnik")int k_id, @RequestParam(name="oglas")int o_id)
	  {
		 return ResponseEntity.status(HttpStatus.OK).body(service.addPrijavu(k_id, o_id));
	  }
}
