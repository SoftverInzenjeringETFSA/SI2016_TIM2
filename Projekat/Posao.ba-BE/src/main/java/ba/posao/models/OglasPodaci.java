package ba.posao.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
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
    @GeneratedValue(generator="SharedPrimaryKeyGenerator")
    @GenericGenerator(name="SharedPrimaryKeyGenerator",strategy="foreign",parameters =  @Parameter(name="property", value="idoglasa"))
    @Column(name = "idpolja", unique = false, nullable = false)
	private Integer id;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="idtemplate")
	private Template template;
			
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="idpolja")
	private List<PoljaTemplatea> poljaTemplatea;
	
	private String vrijednost;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Template getTemplate() {
		return template;
	}

	public void setTemplate(Template template) {
		this.template = template;
	}


	public String getVrijednost() {
		return vrijednost;
	}

	public void setVrijednost(String vrijednost) {
		this.vrijednost = vrijednost;
	}
	
	public List<PoljaTemplatea> getPoljaTemplatea() {
		return poljaTemplatea;
	}
	
	public PoljaTemplatea getPoljeTemplatea() {
		return this.poljaTemplatea.get(0);
	}

	public void setPoljaTemplatea(List<PoljaTemplatea> poljaTemplatea) {
		this.poljaTemplatea = poljaTemplatea;
	}
}
