package ba.posao.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
public class Admin implements Serializable {
	 private static final long serialVersionUID = 1L;
	 
	 @Column(name="idkorisnika")
	 private Integer idKorisnika;
	 private Korisnici korisnik;
	 
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
	    
	    @OneToOne
	    @PrimaryKeyJoinColumn
	    public Korisnici getKorisnici() {
	    	return korisnik;
	    }
	    
	    public void setKorisnici(Korisnici korisnik) {
	    	this.korisnik = korisnik;
	    }

}
