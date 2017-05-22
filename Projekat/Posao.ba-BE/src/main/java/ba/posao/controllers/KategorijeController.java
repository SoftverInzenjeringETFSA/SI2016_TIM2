package ba.posao.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ba.posao.models.Kategorije;
import ba.posao.models.Template;
import ba.posao.services.KategorijeService;


@RestController
@CrossOrigin
@RequestMapping(path="/kategorije") 
public class KategorijeController {
	
	@Autowired	
    private KategorijeService kategorijeService;
	
	@GetMapping(path="/{id}")
	public @ResponseBody Kategorije getKategorijeById(@PathVariable("id") Integer id) {
		return kategorijeService.findByIdKategorije(id);
	}
	
	@CrossOrigin
    @RequestMapping(path="/get/all", method = RequestMethod.GET)
    public List<Kategorije> findAll() {
    	List<Kategorije> k;
    	
    	k = (List<Kategorije>) kategorijeService.findAllKategorije();
    	
    	return k;
    }
    
    @RequestMapping(path="/get", method = RequestMethod.GET)
    public List<Kategorije> viewKategorije(@RequestParam(name = "id", defaultValue = "1") int id, @RequestParam(name = "p", defaultValue = "0") int pageNumber) {
    	List<Kategorije> k = new ArrayList<Kategorije>();
    	
    	if (pageNumber != 0)
    		k = (List<Kategorije>) kategorijeService.getPage(pageNumber);
    	else
        	k.add(kategorijeService.findKategorije(id));
    	
    	return k;
    }
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity register(@RequestBody Kategorije kategory)
    {
	return ResponseEntity.status(HttpStatus.OK).body(kategorijeService.addKategorije(kategory));
    }
    
    @RequestMapping(value = "/remove", method = RequestMethod.DELETE)
    public ResponseEntity delete(@RequestParam(name="id")int id)
    {
    	//if (kategorijeService.findByIdKategorije(id)!=null)
	return ResponseEntity.status(HttpStatus.OK).body(kategorijeService.removeKategorije(id));
    }
    
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity update(@RequestBody Kategorije kategory, @RequestParam(name="id")int id)
    {
    	//if (kategorijeService.findByIdKategorije(id)!=null)
	return ResponseEntity.status(HttpStatus.OK).body(kategorijeService.updateKategorije(kategory, id));
    }
    
    

}
