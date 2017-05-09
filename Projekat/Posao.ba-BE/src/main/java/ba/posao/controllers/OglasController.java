package ba.posao.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ba.posao.models.Oglas;
import ba.posao.models.OglasPodaci;
import ba.posao.repositories.OglasRepository;

@Controller    // This means that this class is a Controller
@RequestMapping(path="/oglasi") 
public class OglasController {

	@Autowired
	private OglasRepository oglasRepository;
	
	@GetMapping(path="/{id}")
	public @ResponseBody Oglas getOglasById(@PathVariable("id") Integer id) {
		return oglasRepository.findById(id);
	}
}
