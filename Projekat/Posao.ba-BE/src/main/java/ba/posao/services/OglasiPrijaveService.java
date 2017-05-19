package ba.posao.services;

import java.util.Date;

import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ba.posao.models.OglasPrijave;
import ba.posao.repositories.NezaposleniRepository;
import ba.posao.repositories.OglasPrijaveRepository;
import ba.posao.repositories.OglasRepository;

@Service
public class OglasiPrijaveService {

	@Autowired
	OglasPrijaveRepository repository;
	
	@Autowired
	OglasRepository oglasRepository;
	
	@Autowired
	NezaposleniRepository korisnikRepository;
	
     public Boolean addPrijavu(int korisnik, int oglas) {
	    	
		 if (oglasRepository.findById(oglas)!=null &&
				 korisnikRepository.findById(korisnik)!=null){
			 
			 if (repository.findByPrijava(oglas, korisnik).size()==0)
			 {
				 OglasPrijave prijava = new OglasPrijave();
				 prijava.setOglas(oglasRepository.findById(oglas));
				 prijava.setNezaposleni(korisnikRepository.findById(korisnik));
				 prijava.setVrijemePrijave((Date) LocalDate.now().toDate());
				 repository.save(prijava);
				 return true;
			 }
			 return false;
		 }
		 else 
	    	return false;
		}
     
}
