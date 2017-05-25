package ba.posao.repositories;

import java.util.List;

import javax.persistence.OrderBy;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ba.posao.models.Oglas;

@Repository
public interface OglasRepository extends PagingAndSortingRepository<Oglas, Integer> {
	@Query("select o from Oglas o where idOglasa=?")
	public Oglas findById(Integer id);
	
	public List<Oglas> findAllByPoslodavacIdKorisnika(Integer idPoslodavca);
	
	public List<Oglas> findAll();
	
	public List<Oglas> findAllByKategorijeNaziv(String naziv);
	
	@Query("SELECT o FROM Oglas o, OglasPodaci op WHERE o.idOglasa=op.id AND vrijednost LIKE %:vrijednost%")
	public List<Oglas> findAllByOglasPodaciVrijednost(@Param("vrijednost")String vrijednost);
	
	@Query("SELECT COUNT(*)  FROM OglasPrijave")
	public Integer brojUspjesnihPrijava();
	
	public List<Oglas> findAllByLokacijaNaziv(String lokacija);
	
	@Query("SELECT o FROM Oglas o WHERE o.naziv LIKE %:name% and o.lokacija.id=:lokacija and o.kategorije.idkategorije=:kategorija ORDER BY o.datumObjave" )
	public List<Oglas> searchASC(@Param("name")String name, 
			@Param("lokacija")Integer idlokacije, 
			@Param("kategorija")Integer idkategorije);	
	
	@Query("SELECT o FROM Oglas o WHERE o.naziv LIKE %:name% and o.lokacija.id=:lokacija and o.kategorije.idkategorije=:kategorija ORDER BY o.datumObjave desc" )
	public List<Oglas> searchDESC(@Param("name")String name, 
			@Param("lokacija")Integer idlokacije, 
			@Param("kategorija")Integer idkategorije);	
	
	@Query("SELECT o FROM Oglas o WHERE o.lokacija.id=:lokacija ORDER BY o.datumObjave desc")
	public List<Oglas> searchLocation(@Param("lokacija")Integer idlokacije);	
	
	@Query("SELECT o FROM Oglas o WHERE o.lokacija.id=:lokacija ORDER BY o.datumObjave")
	public List<Oglas> searchLocationASC(@Param("lokacija")Integer idlokacije);
	
	@Query("SELECT o FROM Oglas o WHERE o.kategorije.idkategorije=:kategorija ORDER BY o.datumObjave desc" )
	public List<Oglas> searchKategory(@Param("kategorija")Integer idkategorije);	
	
	@Query("SELECT o FROM Oglas o WHERE o.kategorije.idkategorije=:kategorija ORDER BY o.datumObjave" )
	public List<Oglas> searchKategoryASC(@Param("kategorija")Integer idkategorije);
	
	@Query("SELECT o FROM Oglas o WHERE o.naziv LIKE %:name% and o.kategorije.idkategorije=:kategorija ORDER BY o.datumObjave desc" )
	public List<Oglas> searchNameCategory(@Param("name")String name, 
			@Param("kategorija")Integer idkategorije);
	
	@Query("SELECT o FROM Oglas o WHERE o.naziv LIKE %:name% and o.kategorije.idkategorije=:kategorija ORDER BY o.datumObjave" )
	public List<Oglas> searchNameCategoryASC(@Param("name")String name, 
			@Param("kategorija")Integer idkategorije);
	
	@Query("SELECT o FROM Oglas o WHERE o.naziv LIKE %:name% and o.lokacija.id=:lokacija ORDER BY o.datumObjave desc" )
	public List<Oglas> searchNameLocatin(@Param("name")String name, 
			@Param("lokacija")Integer idlokacije);	
	
	@Query("SELECT o FROM Oglas o WHERE o.naziv LIKE %:name% and o.lokacija.id=:lokacija ORDER BY o.datumObjave" )
	public List<Oglas> searchNameLocatinASC(@Param("name")String name, 
			@Param("lokacija")Integer idlokacije);	
	
	@Query("SELECT o FROM Oglas o WHERE o.lokacija.id=:lokacija and o.kategorije.idkategorije=:kategorija ORDER BY o.datumObjave" )
	public List<Oglas> searchCategoryLocationASC(@Param("lokacija")Integer idlokacije, 
			@Param("kategorija")Integer idkategorije);	
	
	@Query("SELECT o FROM Oglas o WHERE o.lokacija.id=:lokacija and o.kategorije.idkategorije=:kategorija ORDER BY o.datumObjave desc" )
	public List<Oglas> searchCategoryLocation(@Param("lokacija")Integer idlokacije, 
			@Param("kategorija")Integer idkategorije);	
	
	@Query("SELECT o FROM Oglas o ORDER BY o.datumObjave" )
	public List<Oglas> searchAllASC();	
	
	@Query("SELECT o FROM Oglas o ORDER BY o.datumObjave desc" )
	public List<Oglas> searchAll();	
	
	@Query("SELECT COUNT(k) FROM Oglas k")
	public int getCount();
	
	
}
