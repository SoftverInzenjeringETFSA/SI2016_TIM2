package ba.posao.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="poslodavci")
public class Poslodavci implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator="SharedPrimaryKeyGenerator")
	@GenericGenerator(name="SharedPrimaryKeyGenerator",strategy="foreign",parameters =  @Parameter(name="property", value="korisnici"))
	@Column(name = "idkorisnika", unique = true, nullable = false)
	private Integer idKorisnika;
	
	 
	private String ime;
	private String prezime;
	
	@Column(name="nazivfirme")
	private String nazivFirme;
	private String telefon;
	
	/*@OneToMany
	private List<Oglas> oglasi = new ArrayList<>();*/
	
	public Integer getIdKorisnika() {
		return idKorisnika;
	}

	public void setIdKorisnika(Integer idKorisnika) {
		this.idKorisnika = idKorisnika;
	}


	public String getIme() {
		return ime;
	}
	
	public void setIme(String ime) {
		this.ime = ime;
	}
	
	public String getPrezime() {
		return prezime;
	}
	
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	
	public String getNazivFirme() {
		return nazivFirme;
	}
	
	public void setNazivFirme(String nazivFirme) {
		this.nazivFirme = nazivFirme;
	}
	
	public String getTelefon() {
		return telefon;
	}
	
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	/*public List<Oglas> getOglasi() {
		return oglasi;
	}

	public void setOglasi(List<Oglas> oglasi) {
		this.oglasi = oglasi;
	}	*/
	
	
}
