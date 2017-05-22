package ba.posao.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.joda.time.LocalDate;
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
	    		Date date = (Date) LocalDate.now().toDate();
		    	o.setDatumIsteka(date);
		    	o.setZatvoren(b);
		    	repository.save(o);
		    	return true;
	    	}
	    	return false;	
	   }
	   else return false;
	    }
	   
	   public Boolean reOpenOglas(int id) {
		   if (repository.findById(id)!=null)
		   {
		    	Oglas o = repository.findById(id);
		    	if (o.getZatvoren()==1) {
		    		byte b=0;
			    	o.setZatvoren(b);
			    	repository.save(o);
			    	return true;
		    	}
		    	return false;	
		   }
		   else return false;
		    }
	   
	   public List<Oglas> search(String name, int idlokacije, int idkategorije) {
		   return repository.search(name, idlokacije, idkategorije);
	   }
	   
	   public List<Oglas> searchLocation(int idlokacije) {
		   return repository.searchLocation(idlokacije);
	   }
	   public List<Oglas> searchCategory(int idkategorije) {
		   return repository.searchKategory(idkategorije);
	   }
	   public List<Oglas> searchNameCategory(String name, int idkategorije) {
		   return repository.searchNameCategory(name, idkategorije);
	   }
	   
	   public List<Oglas> searchNameLocation(String name, int idlokacije) {
		   return repository.searchNameLocatin(name, idlokacije);
	   }
	   public List<Oglas> searchCategoryLocation(int idkategorije, int idlokacije) {
		   return repository.searchCategoryLocation(idlokacije, idkategorije);
	   }
}

