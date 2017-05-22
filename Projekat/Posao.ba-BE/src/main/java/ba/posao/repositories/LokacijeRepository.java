package ba.posao.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ba.posao.models.Korisnik;
import ba.posao.models.Lokacije;

@Repository
public interface LokacijeRepository extends PagingAndSortingRepository<Lokacije, Integer> {
	
	public List<Lokacije> findAll();
}
