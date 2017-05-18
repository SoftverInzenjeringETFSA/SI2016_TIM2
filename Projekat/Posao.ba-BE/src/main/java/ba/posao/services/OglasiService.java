package ba.posao.services;

import org.springframework.stereotype.Service;

import ba.posao.models.Oglas;
import ba.posao.repositories.OglasRepository;

@Service
public class OglasiService {
	OglasRepository repository;
	
	 public Boolean addOglas(Oglas k) {
	    	repository.save(k);
	    	return true;
		}
	    
	    public Boolean updateOglas(Oglas k) {
	    	repository.save(k);
	    	return true;
		}

	    public void removeOglas(long id) {
	    	repository.delete(id);
		}
		
}
