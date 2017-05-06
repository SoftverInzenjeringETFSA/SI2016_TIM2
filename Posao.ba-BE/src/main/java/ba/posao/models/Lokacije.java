package ba.posao.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Lokacije {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idlokacije")
	private Integer id;
    
    @ManyToOne(targetEntity=Kantoni.class)
    private Kantoni kanton;

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
    
    
}
