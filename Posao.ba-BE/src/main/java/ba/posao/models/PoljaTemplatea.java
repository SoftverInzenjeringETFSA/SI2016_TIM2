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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import ba.posao.models.Template;
import ba.posao.models.OglasPodaci;

@Entity
@Table(name="poljatemplatea")
public class PoljaTemplatea implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idpolja")
	private Integer id;
    
    @ManyToOne(targetEntity=Template.class,fetch = FetchType.LAZY , cascade=CascadeType.ALL)
    @JoinColumn(name = "idtemplate")
    private Template template;
    
    private String nazivPolja;
    
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<OglasPodaci> oglasPodaci = new ArrayList<>();

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

	public String getNazivPolja() {
		return nazivPolja;
	}

	public void setNazivPolja(String nazivPolja) {
		this.nazivPolja = nazivPolja;
	}
	
	public List<OglasPodaci> getOglasPodaci() {
		return oglasPodaci;
	}

	public void setOglasPodaci(List<OglasPodaci> oglasPodaci) {
		this.oglasPodaci = oglasPodaci;
	}
}
