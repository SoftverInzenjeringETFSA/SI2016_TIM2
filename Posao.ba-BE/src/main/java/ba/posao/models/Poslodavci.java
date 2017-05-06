package ba.posao.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
public class Poslodavci implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Column(name="idkorisnika")
	private Integer idKorisnika;
	private Korisnici korisnik;
	 
	private String ime;
	private String prezime;
	private String nazivFirme;
	private String telefon;
	
    @Id
    @GeneratedValue(generator="SharedPrimaryKeyGenerator")
    @GenericGenerator(name="SharedPrimaryKeyGenerator",strategy="foreign",parameters =  @Parameter(name="property", value="korisnici"))
    @Column(name = "idkorisnika", unique = true, nullable = false)
    public Integer getId() {
    	return idKorisnika;
    }
    
    public void setId(Integer id) {
    	this.idKorisnika = id;
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
	
    @OneToOne
    @PrimaryKeyJoinColumn
    public Korisnici getKorisnici() {
    	return korisnik;
    }
    
    public void setKorisnici(Korisnici korisnik) {
    	this.korisnik = korisnik;
    }
	
}
