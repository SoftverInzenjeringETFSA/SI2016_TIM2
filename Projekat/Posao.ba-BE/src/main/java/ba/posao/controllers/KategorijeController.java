package ba.posao.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ba.posao.models.Kategorije;
import ba.posao.services.KategorijeService;


@RestController
@RequestMapping(path="/kategorije") 
public class KategorijeController {
	
	@Autowired	
    private KategorijeService kategorijeService;
	
	@GetMapping(path="/{id}")
	public @ResponseBody Kategorije getKategorijeById(@PathVariable("id") Integer id) {
		return kategorijeService.findByIdKategorije(id);
	}
	
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
    
    @RequestMapping(path= "/add", method = RequestMethod.GET)
	public String addKategorije(@ModelAttribute("imeForme") Kategorije k){
		
		if(k.getId() == 0) {
			kategorijeService.addKategorije(k);
		}
		else {
			kategorijeService.updateKategorije(k);
		}
		
		return "done";
	}
    
    @RequestMapping(path = "/delete", method = RequestMethod.GET)
    public String deleteKategorije(@RequestParam(name = "id") int id) {
    	
    	kategorijeService.removeKategorije(id);
        return "obavljeno";
    }

}
