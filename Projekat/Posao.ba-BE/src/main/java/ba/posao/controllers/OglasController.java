package ba.posao.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ba.posao.models.Korisnik;
import ba.posao.models.Oglas;
import ba.posao.models.OglasPrijave;
import ba.posao.models.Poslodavci;
import ba.posao.models.OglasDTO;
import ba.posao.repositories.KorisnikRepository;
import ba.posao.repositories.OglasRepository;
import ba.posao.services.KorisnikService;
import ba.posao.services.OglasiService;

@Controller    // This means that this class is a Controller
@RequestMapping(path="/oglasi") 
public class OglasController {

	@Autowired
	private OglasRepository oglasRepository;
	
	@Autowired
	private KorisnikService korisnikService;
	
	@Autowired 
	private OglasiService oglasService;
	
	
	@CrossOrigin
	@GetMapping(path="/get")
	public @ResponseBody Oglas getOglasById(@RequestParam("id") int id) {
		return oglasRepository.findById(id);
	}
	
	@CrossOrigin
	@GetMapping(path="/all")
	public @ResponseBody List<Oglas> findAll() {
		return oglasRepository.findAll();
	}
	
	//svi oglasi poslodavca
	@CrossOrigin
	@GetMapping(path="/poslodavac")
	public @ResponseBody List<Oglas> findByPoslodavac(@RequestParam("id") int id) {
		return oglasRepository.findAllByPoslodavacIdKorisnika(id);
	}
	
	// /oglasi/kategorija?kategorija=...
	@CrossOrigin
	@GetMapping(path="")
	public @ResponseBody List<Oglas> findByKategorije(@RequestParam("kategorija") String kategorija) {
		return oglasRepository.findAllByKategorijeNaziv(kategorija);
	}
	
	//radi donekle
	@CrossOrigin
	@GetMapping(path="/pretraga")
	public @ResponseBody List<Oglas> findByString(@RequestParam("vrijednost") String vrijednost) {
		return oglasRepository.findAllByOglasPodaciVrijednost(vrijednost);
	}
	
	@CrossOrigin
	@GetMapping(path="/pretraga/lokacija")
	public @ResponseBody List<Oglas> findByLokacija(@RequestParam("lokacija") String lokacija) {
		return oglasRepository.findAllByLokacijaNaziv(lokacija);
	}
	
	 @CrossOrigin
	  @RequestMapping(value = "/postavioglas", method = RequestMethod.POST)
	  public ResponseEntity register(@RequestBody OglasDTO oglas)
	  {
		 Oglas _oglas = new Oglas();
		 _oglas.setDatumIsteka(oglas.getDatumIsteka());
		 _oglas.setKategorije(oglas.getKategorije());
		 _oglas.setLokacija(oglas.getLokacija());
		 _oglas.setNaziv(oglas.getNaziv());
		 _oglas.setOglasPodaci(oglas.getOglasPodaci());
		 _oglas.setOglasPrijave(new ArrayList<OglasPrijave>());
		 _oglas.setOpis(oglas.getOpis());
		 _oglas.setPrioritet(oglas.getPrioritet());
		 _oglas.setSakriven(oglas.getSakriven());
		 _oglas.setUspjesan(oglas.getUspjesan());
		 _oglas.setZatvoren(oglas.getZatvoren());
		 _oglas.setOglasPrijave(oglas.getOglasPrijave());
		 
		 Poslodavci poslodavac = korisnikService.findKorisnici(oglas.getPoslodavacId()).getPoslodavac();
		 _oglas.setPoslodavac(poslodavac);
		 
		 return ResponseEntity.status(HttpStatus.OK).body(oglasService.addOglas(_oglas));
		 
			/*korisnik.getNezaposleni().setKorisnici(korisnik);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(korisnikService.registerKorisnik(korisnik)); */
	  }
	 
	 @RequestMapping(value = "/remove", method = RequestMethod.DELETE)
	    public ResponseEntity delete(@RequestParam(name="id")int id)
	    {
		return ResponseEntity.status(HttpStatus.OK).body(oglasService.removeOglas(id));
	    }
	 
	 @RequestMapping(value = "/close", method = RequestMethod.PUT)
	    public ResponseEntity close(@RequestParam(name="id")int id)
	    {
		return ResponseEntity.status(HttpStatus.OK).body(oglasService.closeOglas(id));
	    }
	 
	 @RequestMapping(value = "/reopen", method = RequestMethod.PUT)
	    public ResponseEntity reOpen(@RequestParam(name="id")int id)
	    {
		return ResponseEntity.status(HttpStatus.OK).body(oglasService.reOpenOglas(id));
	    }
	 
	 @RequestMapping(path="/search", method = RequestMethod.GET)
	    public @ResponseBody List<Oglas> search(@RequestParam(name = "name", required=false
	    ) String name, 
	    		@RequestParam(name = "idlok", required=false) Integer idlokacije, 
	    		@RequestParam(name = "idk", required=false) Integer idkategorije) {
	    	
		 
		 if (name!=null && idlokacije!=null & idkategorije!=null)
	    	return oglasService.search(name, idlokacije, idkategorije);
		 else if (name==null & idlokacije!=null & idkategorije==null)
			 return oglasService.searchLocation(idlokacije);
		 else if (name==null & idlokacije==null & idkategorije!=null)
			 return oglasService.searchCategory(idkategorije);
		 else if (name!=null && idlokacije==null & idkategorije==null)
			 return oglasRepository.findAllByOglasPodaciVrijednost(name);
		 else if (idlokacije==null) 
			 return oglasService.searchNameCategory(name, idkategorije);
		 else if (idkategorije==null)
			 return oglasService.searchNameLocation(name, idlokacije);
		 else if (name==null)
			 return oglasService.searchCategoryLocation(idkategorije, idlokacije);
		 else return oglasRepository.findAll();
	    }
}
