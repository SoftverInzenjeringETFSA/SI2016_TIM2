package ba.posao.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="notifikacijapozivnica")
public class NotifikacijaPozivnica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator="SharedPrimaryKeyGenerator")
	@GenericGenerator(name="SharedPrimaryKeyGenerator",strategy="foreign",parameters =  @Parameter(name="property", value="notifikacija"))
	@Column(name = "idnotifikacije", unique = true, nullable = false)
	private Integer idNotifikacije;
/*	
    @ManyToOne(targetEntity=Pozivnice.class)
    @JoinColumn(name="idpozivnice")
    private Pozivnice pozivnica;
*/
	public Integer getIdNotifikacije() {
		return idNotifikacije;
	}

	public void setIdNotifikacije(Integer idNotifikacije) {
		this.idNotifikacije = idNotifikacije;
	}
/*
	public Pozivnice getPozivnica() {
		return pozivnica;
	}

	public void setPozivnica(Pozivnice pozivnica) {
		this.pozivnica = pozivnica;
	}
*/
}
