package ba.posao.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import ba.posao.models.Kategorije;
import ba.posao.models.Template;
import ba.posao.repositories.KategorijeRepository;


@Service
public class KategorijeService {

	private final static int PAGESIZE = 3;

    @Autowired
    KategorijeRepository repository;

    public Iterable<Kategorije> findAllKategorije() {
        return repository.findAll();
    }
    
    public Kategorije findKategorije (int id) {
        return repository.findOne(Integer.valueOf(id));
    }

    public List<Kategorije> getPage(int pageNumber) {
        PageRequest request = new PageRequest(pageNumber - 1, PAGESIZE, Sort.Direction.ASC, "idKategorije");

        return repository.findAll(request).getContent();
    }
    
    public Boolean addKategorije(Kategorije k) {
    	if (repository.findByName(k.getNaziv()).size()==0)
    	repository.save(k);
    	else return false;
    	return true;
	}
    
    //ako nema id
    public Boolean updateKategorije(Kategorije k, int id) {
    	
    	if ( repository.findById(id).equals(null))
    	{    	
    		return false;
    	}
    	else 
    	{ 
    		//repository.delete(repository.findById(id));
    		Kategorije _k = repository.findById(id);
    		_k.setNaziv(k.getNaziv());
    		repository.save(_k);
        	return true;
    	}
    
 
    	
	}

    public Boolean removeKategorije(int id) {
    	repository.delete(id);
    	return true;
	}
    
    public Kategorije findByIdKategorije(Integer id) {
    	return repository.findById(id);
  
	}

	

	

}
