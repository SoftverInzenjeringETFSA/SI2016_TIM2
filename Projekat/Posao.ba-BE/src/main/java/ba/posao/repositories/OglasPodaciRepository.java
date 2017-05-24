package ba.posao.repositories;

import org.springframework.data.repository.CrudRepository;
import ba.posao.models.OglasPodaci;
// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface OglasPodaciRepository extends CrudRepository<OglasPodaci, Long> {

} 
