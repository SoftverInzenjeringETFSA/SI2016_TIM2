package ba.posao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ba.posao.models.Poruke;

public interface PorukeRepository extends JpaRepository<Poruke, Long> {
	@Query("select p from Poruke p where idPoruke=?")
	public Poruke findById(Integer id);	
}