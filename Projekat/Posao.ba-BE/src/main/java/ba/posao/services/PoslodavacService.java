package ba.posao.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ba.posao.repositories.PoslodavacRepository;

@Service
public class PoslodavacService {
	
	@Autowired
	PoslodavacRepository repository;

	 public int getCount()  {
	    	return repository.getCount();
}
}
