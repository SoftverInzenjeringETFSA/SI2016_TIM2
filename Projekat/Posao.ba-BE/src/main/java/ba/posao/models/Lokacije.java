package ba.posao.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Lokacije implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idlokacije")
	private Integer id;
    
    @ManyToOne(targetEntity=Kantoni.class)
    @JoinColumn(name="idkantona")
    private Kantoni kanton;
    
    private String naziv;
    
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Kantoni getKanton() {
		return kanton;
	}

	public void setKanton(Kantoni kanton) {
		this.kanton = kanton;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	
	
}