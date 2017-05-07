package ba.posao.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import ba.posao.models.Oglas;
import ba.posao.models.OglasPodaci;

@Repository
public interface OglasRepository extends PagingAndSortingRepository<Oglas, Long> {
	@Query("select o from Oglas o where idOglasa=?")
	public Oglas findById(Integer id);
}
