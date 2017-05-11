package ba.posao.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ba.posao.models.Oglas;
import ba.posao.repositories.OglasRepository;

@Controller    // This means that this class is a Controller
@RequestMapping(path="/oglasi") 
public class OglasController {

	@Autowired
	private OglasRepository oglasRepository;
	@GetMapping(path="/{id}")
	public @ResponseBody Oglas getOglasById(@PathVariable("id") Integer id) {
		return oglasRepository.findById(id);
	}
	
	//svi oglasi poslodavca
	@GetMapping(path="/poslodavac/{id}")
	public @ResponseBody List<Oglas> findByPoslodavac(@PathVariable("id") Integer id) {
		return oglasRepository.findAllByPoslodavacIdKorisnika(id);
	}
	
	// /oglasi/kategorija?kategorija=...
	@GetMapping(path="/kategorija") 
	public @ResponseBody List<Oglas> findByKategorije(@RequestParam("kategorija") String kategorija) {
		return oglasRepository.findAllByKategorijeNaziv(kategorija);
	}
	
	//radi donekle
	@GetMapping(path="/pretraga")
	public @ResponseBody List<Oglas> findByString(@RequestParam("vrijednost") String vrijednost) {
		return oglasRepository.findAllByOglasPodaciVrijednost(vrijednost);
	}
	
	@GetMapping(path="/pretraga/lokacija")
	public @ResponseBody List<Oglas> findByLokacija(@RequestParam("lokacija") String lokacija) {
		return oglasRepository.findAllByLokacijaNaziv(lokacija);
	}
	
}
