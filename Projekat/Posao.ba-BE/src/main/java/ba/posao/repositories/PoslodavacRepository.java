package ba.posao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ba.posao.models.Poruke;
import ba.posao.models.Poslodavci;

public interface PoslodavacRepository extends  JpaRepository<Poslodavci, Integer> {
	
	
	@Query("SELECT COUNT(k) FROM Poslodavci k")
	public int getCount();

}
