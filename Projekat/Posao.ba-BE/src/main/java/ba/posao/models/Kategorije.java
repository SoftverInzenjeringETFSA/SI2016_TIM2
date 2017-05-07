package ba.posao.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Kategorije implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idkategorije")
	private Integer idkategorije;
    
    /*
    @OneToMany(mappedBy="kategorije",fetch = FetchType.LAZY)
    private List<Oglas> oglas;*/
    
    private String naziv;

	public Integer getId() {
		return idkategorije;
	}

	public void setId(Integer idkategorije) {
		this.idkategorije = idkategorije;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	/*
	public List<Oglas> getOglas() {
		return oglas;
	}

	public void setOglas(List<Oglas> oglas) {
		this.oglas = oglas;
	}*/
	
	
}
