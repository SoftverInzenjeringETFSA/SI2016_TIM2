package ba.posao.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    
    public ResponseEntity addKategorije(Kategorije k) {
    	
    	if (k.getNaziv().equals(""))
    		
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ime kategorije ne može biti prazno");
    	
    	if (repository.findByName(k.getNaziv()).size()==0)
    	repository.save(k);
    	else return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Vec postoji ova kategorija");
    	return ResponseEntity.status(HttpStatus.OK).body(true);
	}
    
    //ako nema id
    public ResponseEntity updateKategorije(Kategorije k, int id) {
    	
    	if ( repository.findById(id)==null)
    	{    	
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ne postoji trazena kategorija");
    	}
    	else 
    	{ 
    		Kategorije _k = repository.findById(id);
    		_k.setNaziv(k.getNaziv());
    		if (repository.findByName(k.getNaziv()).isEmpty())
    		{
    			repository.save(_k);
    			return ResponseEntity.status(HttpStatus.OK).body(true);
    		}
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Vec postoji kategorija sa ovakvim nazivom");
    	}
	}

    public ResponseEntity removeKategorije(int id) {
    	
    	if (repository.findById(id)==null)
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ne postoji trazena kategorija");
    	
    	repository.delete(id);
    	return ResponseEntity.status(HttpStatus.OK).body(true);
	}
    
    public Kategorije findByIdKategorije(Integer id) {
    	return repository.findById(id);
  
	}

	

	

}
