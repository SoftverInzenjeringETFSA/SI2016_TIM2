package ba.posao.services;

import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ba.posao.models.PorukaDTO;
import ba.posao.models.Poruke;
import ba.posao.repositories.KorisnikRepository;
import ba.posao.repositories.PorukeRepository;

@Service
public class PorukeService {
	
	@Autowired 
	PorukeRepository repository;
	
	@Autowired 
	KorisnikRepository korisnikRepository;
	
	public List<Poruke> getMessagesBySender(int id){
		return repository.findBySender(id);
	}
	
	public List<Poruke> getMessagesByRecipient(int id){
		return repository.findByRecipient(id);
	}
	
	public Boolean sendMssg(PorukaDTO poruka){
	
		Poruke p = new Poruke();
		p.setPrimalac(korisnikRepository.findByIdKorisnika(poruka.getPrimalac()));
		p.setPosiljalac(korisnikRepository.findByIdKorisnika(poruka.getPosiljalac()));
		p.setVrijeme((Date) LocalDate.now().toDate());
		p.setTekst(poruka.getTekst());
		p.setProcitano(false);
		repository.save(p);
		return true;
	}
	
	
}
