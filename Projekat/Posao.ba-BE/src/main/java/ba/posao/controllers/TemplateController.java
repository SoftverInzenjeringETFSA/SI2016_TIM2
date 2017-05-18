package ba.posao.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import ba.posao.models.Template;
import ba.posao.services.TemplateService;

@Controller    // This means that this class is a Controller. no shit??
@CrossOrigin
@RequestMapping(path="/template") 
public class TemplateController {
	
	

	@Autowired
	TemplateService repository;
	
	@GetMapping(path="/{id}")
	public @ResponseBody Template getTemplateById(@PathVariable("id") Integer id) {
		return repository.findById(id);
	}

}
