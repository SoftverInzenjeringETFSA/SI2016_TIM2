package ba.posao.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import ba.posao.models.Notifikacija;

@Repository
public interface NotifikacijaRepository extends PagingAndSortingRepository<Notifikacija, Long> {
	@Query("select n from Notifikacija n where idNotifikacije=?")
	public Notifikacija findById(Integer id);
}
