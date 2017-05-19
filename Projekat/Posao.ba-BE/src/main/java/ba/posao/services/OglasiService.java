package ba.posao.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ba.posao.models.Oglas;
import ba.posao.repositories.OglasRepository;

@Service
public class OglasiService {
	
	@Autowired
	OglasRepository repository;
	
	 public Boolean addOglas(Oglas k) {
	    	repository.save(k);
	    	return true;
		}
	    
	    public Boolean updateOglas(Oglas k) {
	    	repository.save(k);
	    	return true;
		}

	    public Boolean removeOglas(int id) {
	    	repository.delete(id);
	    	return true;
		}
		
}
