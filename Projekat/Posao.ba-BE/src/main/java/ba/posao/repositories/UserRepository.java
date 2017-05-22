package ba.posao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ba.posao.models.Korisnik;

public interface UserRepository extends JpaRepository<Korisnik, Long> {

}
