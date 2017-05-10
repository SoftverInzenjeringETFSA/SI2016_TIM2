package ba.posao.models;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;


@Entity
@Table(name="poljatemplatea")
public class PoljaTemplatea implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idpolja")
	private Integer id;
 
    @Column(name="nazivpolja")
    private String nazivPolja;
	
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
}
