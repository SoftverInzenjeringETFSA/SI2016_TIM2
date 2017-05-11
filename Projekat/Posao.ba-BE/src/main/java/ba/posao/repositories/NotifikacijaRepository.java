package ba.posao.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import ba.posao.models.Notifikacija;

@Repository
public interface NotifikacijaRepository extends PagingAndSortingRepository<Notifikacija, Integer> {
	@Query("select n from Notifikacija n where idNotifikacije=?")
	public Notifikacija findById(Integer id);
}
