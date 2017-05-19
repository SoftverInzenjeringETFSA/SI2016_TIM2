package ba.posao.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import ba.posao.models.OglasPrijave;

@Repository
public interface OglasPrijaveRepository extends PagingAndSortingRepository<OglasPrijave, Integer> {
	
	@Query("select o from OglasPrijave o where idOglasa=? and idKorisnika=?")
	public ArrayList<OglasPrijave> findByPrijava(Integer idOglasa, Integer idKorisnika);


}
