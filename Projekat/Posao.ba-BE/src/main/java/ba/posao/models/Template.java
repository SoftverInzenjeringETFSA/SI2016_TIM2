package ba.posao.models;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
public class Template implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idtemplate")
	private Integer id;
	
	private String naziv;
	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "template")
	private Set<PoljaTemplatea> poljaTemplatea;
	
	
	public Set<PoljaTemplatea> getPoljaTemplatea() {
		return this.poljaTemplatea;
	}
	
	public void setPoljaTemplatea(Set<PoljaTemplatea> p)
	{
		this.poljaTemplatea=p;
	}
	
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
	
}
