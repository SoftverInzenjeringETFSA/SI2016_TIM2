package ba.posao.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Lokacije implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idlokacije")
	private Integer id;
    
    @ManyToOne(targetEntity=Kantoni.class)
    @JoinColumn(name="idkantona")
    private Kantoni kanton;
    
    /*@OneToMany(targetEntity=Oglas.class)
    private List<Oglas> oglasi = new ArrayList<>();*/

    
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

	/*public List<Oglas> getOglasi() {
		return oglasi;
	}

	public void setOglasi(List<Oglas> oglasi) {
		this.oglasi = oglasi;
	}    */
}