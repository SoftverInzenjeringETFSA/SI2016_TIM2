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

import ba.posao.models.Korisnici;
import ba.posao.models.Nezaposleni;
import ba.posao.repositories.KorisnikRepository;
import ba.posao.repositories.NezaposleniRepository;

@Service
public class NezaposleniService{

    @Autowired
    NezaposleniRepository repository;
    
    public Boolean registerNezaposleni(Nezaposleni n) {
    	Nezaposleni nez = repository.save(n);
    	
    	return nez != null; 
	}
}
