package ba.posao.services;

import static org.mockito.Mockito.RETURNS_DEEP_STUBS;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ba.posao.models.Oglas;
import ba.posao.models.OglasPodaci;
import ba.posao.repositories.OglasPodaciRepository;
import ba.posao.repositories.OglasRepository;

@Service
public class OglasiService {
	
	@Autowired
	OglasRepository repository;
	
	@Autowired
	OglasPodaciRepository podaciRepository;
	
	 public Boolean addOglas(Oglas k) {
		 	k.setDatumObjave(new Date());
	    	Oglas _oglas = repository.save(k);
	    	
	    	for(OglasPodaci podatak : k.getOglasPodaci()){
	    		podatak.setOglas(_oglas);
	    	}
	    	
	    	podaciRepository.save(k.getOglasPodaci());
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
	   
	   public List<Oglas> search(String name, int idlokacije, int idkategorije, Boolean order) {
		   if (order)
		   return repository.searchASC(name, idlokacije, idkategorije);
		   else return repository.searchDESC(name, idlokacije, idkategorije);
		   
	   }
	   
	   public List<Oglas> searchLocation(int idlokacije, Boolean order) {
		   if (order)
		   return repository.searchLocationASC(idlokacije);
		   else return repository.searchLocation(idlokacije);
	   }
	   public List<Oglas> searchCategory(int idkategorije, Boolean order) {
		   if (order)
		   return repository.searchKategoryASC(idkategorije);
		   else return repository.searchKategory(idkategorije);
	   }
	   public List<Oglas> searchNameCategory(String name, int idkategorije, Boolean order) {
		   if (order)
		   return repository.searchNameCategoryASC(name, idkategorije);
		   else return repository.searchNameCategory(name, idkategorije);
	   }
	   
	   public List<Oglas> searchNameLocation(String name, int idlokacije, Boolean order) {
		   if (order)
		   return repository.searchNameLocatinASC(name, idlokacije);
		   else return repository.searchNameLocatin(name, idlokacije);
	   }
	   public List<Oglas> searchCategoryLocation(int idkategorije, int idlokacije, Boolean order) {
		   if (order)
		   return repository.searchCategoryLocation(idlokacije, idkategorije);
		   else return repository.searchCategoryLocation(idlokacije, idkategorije);
	   }
	   
	   public List<Oglas> searchAll(Boolean order)
	   {
		   if (order)
			   return repository.searchAllASC();
		   else return repository.searchAll();
			   
	   }
	   
	   public int getCount() {
		   return repository.getCount();
	   }
	   
	   
	   
}

