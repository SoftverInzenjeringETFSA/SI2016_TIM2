package ba.posao.models;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import ba.posao.models.PoljaTemplatea;
import ba.posao.models.OglasPodaci;

public class Template {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idtemplate")
	private Integer id;
	
	private String naziv;
	
	@OneToMany
	private ArrayList<PoljaTemplatea> poljaTemplatea = new ArrayList<>();
	
	@OneToMany
	private ArrayList<OglasPodaci> oglasPodaci = new ArrayList<>();


	public Integer getId() {
    	return id;
    }
    
    public void setId(Integer Id) {
    	this.id = Id;
    }
    
	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	
	
    public ArrayList<PoljaTemplatea> getPoljaTemplatea() {
		return poljaTemplatea;
	}

	public void setPoljaTemplatea(ArrayList<PoljaTemplatea> poljaTemplatea) {
		this.poljaTemplatea = poljaTemplatea;
	}

	public ArrayList<OglasPodaci> getOglasPodaci() {
		return oglasPodaci;
	}

	public void setOglasPodaci(ArrayList<OglasPodaci> oglasPodaci) {
		this.oglasPodaci = oglasPodaci;
	}
}
