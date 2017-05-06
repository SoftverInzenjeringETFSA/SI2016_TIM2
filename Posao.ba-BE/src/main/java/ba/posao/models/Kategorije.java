package ba.posao.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Kategorije {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idkategorije")
	private Integer idkategorije;
    
    @OneToOne
    private Oglas oglas;
    
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
}
