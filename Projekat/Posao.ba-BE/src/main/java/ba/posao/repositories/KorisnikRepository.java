package ba.posao.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ba.posao.models.Korisnik;

@Repository
public interface KorisnikRepository extends PagingAndSortingRepository<Korisnik, Integer> {
	
	public Korisnik findByEmail(String email);
	public Korisnik findByUsername(String username);
	public Korisnik findByIdKorisnika(Integer id);
	public List<Korisnik> findAll();
	
	
	@Query("SELECT o FROM Nezaposleni o WHERE CONCAT(o.ime, o.prezime) LIKE %:name%")
	public List<Korisnik> findUsersByUsername (@Param("name")String name);
}
