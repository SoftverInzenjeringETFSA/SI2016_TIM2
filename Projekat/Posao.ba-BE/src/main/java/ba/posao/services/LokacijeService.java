package ba.posao.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import ba.posao.models.Kategorije;
import ba.posao.models.Lokacije;
import ba.posao.models.Template;
import ba.posao.repositories.KategorijeRepository;
import ba.posao.repositories.LokacijeRepository;


@Service
public class LokacijeService {

	private final static int PAGESIZE = 3;

    @Autowired
    LokacijeRepository repository;

    public Iterable<Lokacije> findAllLokacije() {
        return repository.findAll();
    }

}
