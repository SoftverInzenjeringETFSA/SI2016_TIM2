package ba.posao.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import ba.posao.models.Korisnik;
import ba.posao.repositories.KorisnikRepository;

@Service
public class KorisnikService implements UserDetailsService{

	private final static int PAGESIZE = 3;

    @Autowired
    KorisnikRepository repository;

    public Iterable<Korisnik> findAllKorisnici() {
        return repository.findAll();
    }
    
    public Korisnik findKorisnici (int id) {
        return repository.findOne(Integer.valueOf(id));
    }

    public List<Korisnik> getPage(int pageNumber) {
        PageRequest request = new PageRequest(pageNumber - 1, PAGESIZE, Sort.Direction.ASC, "idKorisnika");

        return repository.findAll(request).getContent();
    }
    
    public void addKorisnici(Korisnik k) {
    	repository.save(k);
	}
    
    public Boolean updateKorisnici(Korisnik k, int id) {
    	Korisnik _k=repository.findByIdKorisnika(id);
    	_k=k;
    	_k.setIdKorisnika(id);
    	repository.save(_k);
    	return true;
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
    	Korisnik k = repository.findByIdKorisnika(id);
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
    
	public String getKorisnikTypeByUserName(String username) {
    	Korisnik k = repository.findByUsername(username);
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
    public Boolean registerKorisnik(Korisnik korisnik) {
    	
    	// Registracija nije implementirana do kraja

        if(repository.findByUsername(korisnik.getUsername()) != null) {
            throw new ServiceException("Korisnik sa datim username-om vec postoji!");
        }

        Korisnik kreiranKorisnik = repository.save(korisnik);

        return kreiranKorisnik != null;

    }
	 @Override
	    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

	        Korisnik korisnik = repository.findByUsername(s);
	        if(korisnik == null) {
	            throw new UsernameNotFoundException("Nije pronađen korisnik s takvim username-om");
	        }
	        return new User(korisnik.getUsername(), korisnik.getPassword(), getGrantedAuthorities(korisnik));
	    }

	    private Collection<GrantedAuthority> getGrantedAuthorities(Korisnik korisnik) {
	        Collection<GrantedAuthority> authorities = new ArrayList<>();
	        if(korisnik.getNezaposleni() != null || korisnik.getPoslodavac() != null || korisnik.getAdmin() != null) {
	           authorities.add(new SimpleGrantedAuthority(korisnik.getUsername()));
	        }
	        return authorities;
	    }
	    
	    public Korisnik getKorisnikByUserName(String username) {
	    	return repository.findByUsername(username);
	    	
	    }
	    
	    public List<Korisnik> findByName(String name) {
	    	
	      return repository.findUsersByName(name);
	    }

}
