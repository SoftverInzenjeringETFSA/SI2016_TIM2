package ba.posao.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import ba.posao.models.Korisnici;

public interface KorisnikRepository extends PagingAndSortingRepository<Korisnici, Integer> {
	public Korisnici findByEmail(String email);
	public Korisnici findByUsername(String username);
	public Korisnici findByIdKorisnika(Integer id);
	
	public List<Korisnici> findAll();
}
