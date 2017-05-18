package ba.posao.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ba.posao.models.Template;
import ba.posao.repositories.TemplateRepository;

@Service
public class TemplateService {
	
	@Autowired
	TemplateRepository repository;
	
	public Template findById(Integer id) 
	{
		return repository.findById(id);
	}

}
