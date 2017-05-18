package ba.posao.models;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="poljatemplatea")
public class PoljaTemplatea implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Integer id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name = "idtemplate", nullable = false)
	private Template template;
	
   @Column(name="nazivpolja")
   private String nazivPolja;	
	
	public Template getTemplate() {
		return this.template;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNazivPolja() {
		return nazivPolja;
	}

	public void setNazivPolja(String nazivPolja) {
		this.nazivPolja = nazivPolja;
	}	
	
	public void setTemplate(Template template)
	{
		this.template=template;
	}
}
