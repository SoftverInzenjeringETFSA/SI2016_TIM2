package ba.posao.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import ba.posao.models.Nezaposleni;
// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface NezaposleniRepository extends CrudRepository<Nezaposleni, Integer> {
	@Query("select k from Nezaposleni k where idKorisnika=?")
	public Nezaposleni findById(Integer id);
} 
