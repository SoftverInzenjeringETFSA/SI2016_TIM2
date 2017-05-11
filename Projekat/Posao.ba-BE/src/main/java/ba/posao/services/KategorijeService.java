package ba.posao.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import ba.posao.models.Kategorije;
import ba.posao.repositories.KategorijeRepository;


@Service
public class KategorijeService {

	private final static int PAGESIZE = 3;

    @Autowired
    KategorijeRepository repository;

    public Iterable<Kategorije> findAllKategorije() {
        return repository.findAll();
    }
    
    public Kategorije findKategorije (int id) {
        return repository.findOne(Integer.valueOf(id));
    }

    public List<Kategorije> getPage(int pageNumber) {
        PageRequest request = new PageRequest(pageNumber - 1, PAGESIZE, Sort.Direction.ASC, "idKategorije");

        return repository.findAll(request).getContent();
    }
    
    public void addKategorije(Kategorije k) {
    	repository.save(k);
	}
    
    public void updateKategorije(Kategorije k) {
    	repository.save(k);
	}

    public void removeKategorije(int id) {
    	repository.delete(id);
	}
    
    public Kategorije findByIdKategorije(Integer id) {
    	return repository.findById(id);
	}

}
