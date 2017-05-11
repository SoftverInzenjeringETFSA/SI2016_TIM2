package ba.posao.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ba.posao.models.Poruke;
import ba.posao.repositories.PorukeRepository;

@Controller    // This means that this class is a Controller
@RequestMapping(path="/poruke") 
public class PorukeController {
	@Autowired
	
	private PorukeRepository porukeRepository;
	
	@GetMapping(path="/{id}")
	public @ResponseBody Poruke getPorukeById(@PathVariable("id") Integer id) {
		return porukeRepository.findById(id);
	}
}
