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
	    
	    public Boolean closeOglas(int id) {
	   if (repository.findById(id)!=null)
	   {
	    	Oglas o = repository.findById(id);
	    	if (o.getZatvoren()==0) {
	    		byte b=1;
		    	
		    	o.setZatvoren(b);
		    	repository.save(o);
		    	return true;
	    	}
	    	return false;	
	   }
	   else return false;
	    }
}
