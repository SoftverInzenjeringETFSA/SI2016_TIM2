package ba.posao.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Lokacije {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idlokacije")
	private Integer id;
    
    @ManyToOne(targetEntity=Kantoni.class)
    private Kantoni kanton;
    
    @OneToMany
    private List<Oglas> oglasi = new ArrayList<>();

    
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

	public List<Oglas> getOglasi() {
		return oglasi;
	}

	public void setOglasi(List<Oglas> oglasi) {
		this.oglasi = oglasi;
	}    
}