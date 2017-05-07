package ba.posao.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ba.posao.models.Korisnici;
import ba.posao.services.KorisnikService;

@RestController
@RequestMapping(path="/korisnici")
public class KorisnikController {

	@Autowired
    private KorisnikService korisnikService;
 
    @RequestMapping(path="/save")
    public String process() {
/*    	korisnikService.save(new Customer("Jack", "Smith"));
    	korisnikService.save(new Customer("Adam", "Johnson"));
    	korisnikService.save(new Customer("Kim", "Smith"));
    	korisnikService.save(new Customer("David", "Williams"));
    	korisnikService.save(new Customer("Peter", "Davis"));*/
        return "Done";
    }
 
    @RequestMapping(path="/findall")
    public String findAll() {
        String result = "<html>";
 
        for (Korisnici k : korisnikService.findAllKorisnici()) {
            result += k.toString() + "<br>";
        }
 
        return result + "</html>";
    }
 
    @RequestMapping(path="/customers", method = RequestMethod.GET)
    public String viewCustomers(@RequestParam(name = "p", defaultValue = "1") int pageNumber) {
        String result = "<html>";
 
        List<Korisnici> korisnici = korisnikService.getPage(pageNumber);
 
        for (Korisnici k : korisnici) {
            result += k.toString() + "</br>";
        }
 
        return result + "</html>";
    }

}
