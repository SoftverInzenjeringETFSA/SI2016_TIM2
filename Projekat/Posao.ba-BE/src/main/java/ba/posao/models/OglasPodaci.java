package ba.posao.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import ba.posao.models.Template;
import ba.posao.models.PoljaTemplatea;

@Entity
@Table(name="oglaspodaci")
public class OglasPodaci implements Serializable {
	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "idpolja")
	private Integer id;
	
    private String staje;
    public String getStaje() {
		return staje;
	}
    public void setStaje(String e)
    {
    	this.staje=e;
    }

	private String vrijednost;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getVrijednost() {
		return vrijednost;
	}

	public void setVrijednost(String vrijednost) {
		this.vrijednost = vrijednost;
	}
	
}
