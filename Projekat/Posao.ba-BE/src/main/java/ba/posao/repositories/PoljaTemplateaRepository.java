package ba.posao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ba.posao.models.PoljaTemplatea;
import ba.posao.models.Template;

public interface PoljaTemplateaRepository extends JpaRepository<PoljaTemplatea, Long> {

	@Query("select p from Template p where idTemplate=?")
	public Template findById(Integer id);
}
