package ba.posao.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import ba.posao.models.Korisnici;

public interface KorisnikRepository extends PagingAndSortingRepository<Korisnici, Long> {

}
