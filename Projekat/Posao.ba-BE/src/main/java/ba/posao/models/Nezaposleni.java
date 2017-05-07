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
public class Nezaposleni implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(generator="SharedPrimaryKeyGenerator")
	@GenericGenerator(name="SharedPrimaryKeyGenerator",strategy="foreign",parameters =  @Parameter(name="property", value="korisnici"))
	@Column(name = "idkorisnika", unique = true, nullable = false)
	private Integer idKorisnika;
	
	private String ime;
	private String prezime;
	private String cv;
	
	@Column(name="privatanprofil")
	private Integer privatanProfil;
	
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

	public String getCv() {
		return cv;
	}

	public void setCv(String cv) {
		this.cv = cv;
	}

	public Integer getPrivatanProfil() {
		return privatanProfil;
	}

	public void setPrivatanProfil(Integer privatanProfil) {
		this.privatanProfil = privatanProfil;
	}
}
