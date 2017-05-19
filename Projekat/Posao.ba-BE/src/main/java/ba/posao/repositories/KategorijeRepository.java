package ba.posao.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import ba.posao.models.Kategorije;

@Repository
public interface KategorijeRepository extends PagingAndSortingRepository<Kategorije, Integer> {
	@Query("select k from Kategorije k where idKategorije=?")
	public Kategorije findById(Integer id);
	
	@Query("select k from Kategorije k where naziv=?")
	public ArrayList<Kategorije> findByName(String id);
	
	
}
