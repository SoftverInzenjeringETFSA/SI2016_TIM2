package ba.posao.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import ba.posao.models.Notifikacija;
import ba.posao.repositories.NotifikacijaRepository;


@Service
public class NotifikacijaService {

	private final static int PAGESIZE = 3;

    @Autowired
    NotifikacijaRepository repository;

    public Iterable<Notifikacija> findAllNotifikacija() {
        return repository.findAll();
    }
    
    public Notifikacija findNotifikacija (int id) {
        return repository.findOne(Integer.valueOf(id));
    }

    public List<Notifikacija> getPage(int pageNumber) {
        PageRequest request = new PageRequest(pageNumber - 1, PAGESIZE, Sort.Direction.ASC, "idNotifikacije");

        return repository.findAll(request).getContent();
    }
    
    public void addNotifikacija(Notifikacija n) {
    	repository.save(n);
	}
    
    public void updateNotifikacija(Notifikacija n) {
    	repository.save(n);
	}

    public void removeNotifikacija(int id) {
    	repository.delete(id);
	}


}
