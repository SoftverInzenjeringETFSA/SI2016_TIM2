package ba.posao.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import ba.posao.models.Korisnici;
import ba.posao.repositories.KorisnikRepository;

@Service
public class KorisnikService {

	private final static int PAGESIZE = 3;

    @Autowired
    KorisnikRepository repository;

    public Iterable<Korisnici> findAllKorisnici() {
        return repository.findAll();
    }
    
    public Korisnici findKorisnici (int id) {
        return repository.findOne(Integer.valueOf(id));
    }

    public List<Korisnici> getPage(int pageNumber) {
        PageRequest request = new PageRequest(pageNumber - 1, PAGESIZE, Sort.Direction.ASC, "idKorisnika");

        return repository.findAll(request).getContent();
    }
    
    public void addKorisnici(Korisnici k) {
    	repository.save(k);
	}
    
    public void updateKorisnici(Korisnici k) {
    	repository.save(k);
	}

    public void removeKorisnici(int id) {
    	repository.delete(id);
	}
    
    /*
     * Zbog dizajna baze ne čuva se tip korisnika
     * Potrebno je iz tabele odrediti koji je to tip
     * Koristiti za određivanje privilegija
     * */
    
    public String getKorisnikType(int id) {
    	Korisnici k = repository.findByIdKorisnika(id);
    	if(k == null)
    		return "ERROR_NULL";
    	
    	if(k.getPoslodavac() != null)
    		return "ROLE_POSLODAVAC";
    	if(k.getNezaposleni() != null)
    		return "ROLE_NEZAPOSLENI";
    	if(k.getAdmin() != null)
    		return "ROLE_ADMIN";
    	
    	return "ERROR_UNKNOWN";
    }
    
    
}
