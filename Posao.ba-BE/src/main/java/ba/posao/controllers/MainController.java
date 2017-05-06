package ba.posao.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ba.posao.models.Kantoni;
import ba.posao.repositories.KantoniRepository;


@Controller    // This means that this class is a Controller
@RequestMapping(path="/demo") // This means URL's start with /demo (after Application path)
public class MainController {
	@Autowired // This means to get the bean called KantoniRepository
	           // Which is auto-generated by Spring, we will use it to handle the data

	@GetMapping(path="/all")
	public @ResponseBody String getAllKantoni() {
		// This returns a JSON or XML with the users
		return "uradjeno";
	}
}