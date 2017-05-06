package ba.posao.models;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
public class OglasPodaci {
	
	private Integer id;
	
    @OneToOne(targetEntity=Oglas.class)
    @PrimaryKeyJoinColumn
	private Oglas oglas;
	
	@OneToMany(targetEntity=Template.class, mappedBy="template")
	private ArrayList<Template> template = new ArrayList<>();
	
	@OneToMany(targetEntity=PoljaTemplatea.class, mappedBy="poljatemplatea")
	private ArrayList<PoljaTemplatea> poljaTemplatea = new ArrayList<>();
	
	private String vrijednost;

    @Id
    @GeneratedValue(generator="SharedPrimaryKeyGenerator")
    @GenericGenerator(name="SharedPrimaryKeyGenerator",strategy="foreign",parameters =  @Parameter(name="property", value="oglas"))
    @Column(name = "idoglasa", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Oglas getOglas() {
		return oglas;
	}

	public void setOglas(Oglas oglas) {
		this.oglas = oglas;
	}

	@ManyToOne
    @JoinColumn(name = "idTemplate")
	public ArrayList<Template> getTemplate() {
		return template;
	}

	public void setTemplate(ArrayList<Template> template) {
		this.template = template;
	}

	
	public ArrayList<PoljaTemplatea> getPoljaTemplatea() {
		return poljaTemplatea;
	}

	public void setPoljaTemplatea(ArrayList<PoljaTemplatea> poljaTemplatea) {
		this.poljaTemplatea = poljaTemplatea;
	}

	public String getVrijednost() {
		return vrijednost;
	}

	public void setVrijednost(String vrijednost) {
		this.vrijednost = vrijednost;
	}
	

}
