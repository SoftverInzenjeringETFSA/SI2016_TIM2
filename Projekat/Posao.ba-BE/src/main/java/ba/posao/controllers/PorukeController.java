package ba.posao.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ba.posao.models.Lokacije;
import ba.posao.models.PorukaDTO;
import ba.posao.models.Poruke;
import ba.posao.repositories.PorukeRepository;
import ba.posao.services.PorukeService;

@Controller    // This means that this class is a Controller. no shit??
@CrossOrigin
@RequestMapping(path="/poruke") 
public class PorukeController {
	
	@Autowired
	PorukeService service;
	
	@CrossOrigin
    @RequestMapping(path="/get/sender", method = RequestMethod.GET)
    public  @ResponseBody List<Poruke> findS(@RequestParam("sender") int id) {
		return service.getMessagesBySender(id);
	}
	@CrossOrigin
    @RequestMapping(path="/get", method = RequestMethod.GET)
    public  @ResponseBody List<Poruke> findR(@RequestParam("recipient") int id) {
		return service.getMessagesByRecipient(id);
	}
	
	@CrossOrigin
    @RequestMapping(path="/send", method = RequestMethod.POST)
    public  @ResponseBody Boolean findAll(@RequestBody PorukaDTO poruka) {
		return service.sendMssg(poruka);
	}
}
