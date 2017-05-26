package ba.posao.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ba.posao.models.Poruke;

public interface PorukeRepository extends JpaRepository<Poruke, Long> {
	@Query("select p from Poruke p where idPoruke=?")
	public Poruke findById(Integer id);	
	
	@Query("select p from Poruke p where idPrimaoca=?")
	public List<Poruke> findByRecipient(Integer id);	
	
	@Query("select p from Poruke p where idPosiljaoca=?")
	public List<Poruke> findBySender(Integer id);
	
	@Query("select count(p) from Poruke p where procitano=false and idPrimaoca=?")
	public int countUnread(Integer id);
	
	
}