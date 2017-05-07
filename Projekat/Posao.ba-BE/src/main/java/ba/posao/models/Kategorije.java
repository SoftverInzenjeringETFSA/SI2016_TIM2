package ba.posao.models;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Kategorije implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idkategorije")
	private Integer idkategorije;

    
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
