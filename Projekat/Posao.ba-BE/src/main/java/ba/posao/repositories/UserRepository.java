package ba.posao.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ba.posao.models.Korisnici;

public interface UserRepository extends JpaRepository<Korisnici, Long> {

}
