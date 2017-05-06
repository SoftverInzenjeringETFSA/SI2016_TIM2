package ba.posao.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import ba.posao.models.Template;

@Entity
public class PoljaTemplatea {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idpolja")
	private Integer id;
    
    @ManyToOne(targetEntity=Template.class)
    private Template template;
    
    private String nazivPolja;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne
    @JoinColumn(name = "idTemplate")
	public Template getTemplate() {
		return template;
	}

	public void setTemplate(Template template) {
		this.template = template;
	}

	public String getNazivPolja() {
		return nazivPolja;
	}

	public void setNazivPolja(String nazivPolja) {
		this.nazivPolja = nazivPolja;
	}
}
