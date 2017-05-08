package ba.posao.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Pozivnice implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idpozivnice")
	private Integer idPozivnice;
	
    @ManyToOne(targetEntity=Nezaposleni.class)
    @JoinColumn(name="idkorisnika")
    private Nezaposleni idKorisnika;
    
    @ManyToOne(targetEntity=Oglas.class)
    @JoinColumn(name="idoglasa")
    private Oglas idOglasa;

	public Integer getIdPozivnice() {
		return idPozivnice;
	}

	public void setIdPozivnice(Integer idPozivnice) {
		this.idPozivnice = idPozivnice;
	}

	public Nezaposleni getIdKorisnika() {
		return idKorisnika;
	}

	public void setIdKorisnika(Nezaposleni idKorisnika) {
		this.idKorisnika = idKorisnika;
	}

	public Oglas getIdOglasa() {
		return idOglasa;
	}

	public void setIdOglasa(Oglas idOglasa) {
		this.idOglasa = idOglasa;
	}

	
}
