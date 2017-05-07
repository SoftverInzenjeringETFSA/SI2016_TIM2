package ba.posao.repositories;

import org.springframework.data.repository.CrudRepository;
import ba.posao.models.Kantoni;
// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface KantoniRepository extends CrudRepository<Kantoni, Long> {

} 
