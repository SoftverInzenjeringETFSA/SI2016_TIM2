package ba.posao.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import ba.posao.models.PoljaTemplatea;
import ba.posao.models.OglasPodaci;

@Entity
public class Template implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idtemplate")
	private Integer id;
	
	private String naziv;
	
	@OneToMany(mappedBy="template",  cascade=CascadeType.ALL)
	private List<PoljaTemplatea> poljaTemplatea = new ArrayList<>();
	
	@OneToMany(mappedBy="template", cascade=CascadeType.ALL)
	private List<OglasPodaci> oglasPodaci = new ArrayList<>();


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
	

	public List<PoljaTemplatea> getPoljaTemplatea() {
		return poljaTemplatea;
	}

	public void setPoljaTemplatea(ArrayList<PoljaTemplatea> poljaTemplatea) {
		this.poljaTemplatea = poljaTemplatea;
	}

	public List<OglasPodaci> getOglasPodaci() {
		return oglasPodaci;
	}

	public void setOglasPodaci(ArrayList<OglasPodaci> oglasPodaci) {
		this.oglasPodaci = oglasPodaci;
	}
}
