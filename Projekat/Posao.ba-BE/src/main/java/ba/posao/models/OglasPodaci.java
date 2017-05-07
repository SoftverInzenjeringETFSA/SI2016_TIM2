package ba.posao.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
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
    @GeneratedValue(generator="SharedPrimaryKeyGenerator")
    @GenericGenerator(name="SharedPrimaryKeyGenerator",strategy="foreign",parameters =  @Parameter(name="property", value="idoglasa"))
    @Column(name = "idoglasa", unique = true, nullable = false)
	private Integer id;
	
    @OneToOne(targetEntity=Oglas.class)
    @PrimaryKeyJoinColumn(name="idoglasa")
	private Oglas oglas;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="idtemplate")
	private Template template;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="idpolja")
	private PoljaTemplatea poljeTemplatea;
	
	private String vrijednost;

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


	public Template getTemplate() {
		return template;
	}

	public void setTemplate(Template template) {
		this.template = template;
	}

	public PoljaTemplatea getPoljeTemplatea() {
		return poljeTemplatea;
	}

	public void setPoljeTemplatea(PoljaTemplatea poljeTemplatea) {
		this.poljeTemplatea = poljeTemplatea;
	}

	public String getVrijednost() {
		return vrijednost;
	}

	public void setVrijednost(String vrijednost) {
		this.vrijednost = vrijednost;
	}
	

}
