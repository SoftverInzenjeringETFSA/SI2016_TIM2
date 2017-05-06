package ba.posao.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Oglas {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idoglasa")
	private Integer idOglasa;
    
    @OneToOne
    private Poslodavci poslodavac;
    
    @OneToOne
    private Lokacije lokacija;
    
    @OneToOne
    private Kategorije kategorije;
    
    private Date datumObjave;
    private Date datumIsteka;
    private byte sakriven;
    private byte zatvoren;
    private byte uspjesan;
    
    private Integer prioritet;

	public Integer getId() {
		return idOglasa;
	}

	public void setId(Integer idOglasa) {
		this.idOglasa = idOglasa;
	}

	public Poslodavci getPoslodavac() {
		return poslodavac;
	}

	public void setPoslodavac(Poslodavci poslodavac) {
		this.poslodavac = poslodavac;
	}

	public Lokacije getLokacija() {
		return lokacija;
	}

	public void setLokacija(Lokacije lokacija) {
		this.lokacija = lokacija;
	}

	public Kategorije getKategorije() {
		return kategorije;
	}

	public void setKategorije(Kategorije kategorije) {
		this.kategorije = kategorije;
	}

	public Date getDatumObjave() {
		return datumObjave;
	}

	public void setDatumObjave(Date datumObjave) {
		this.datumObjave = datumObjave;
	}

	public Date getDatumIsteka() {
		return datumIsteka;
	}

	public void setDatumIsteka(Date datumIsteka) {
		this.datumIsteka = datumIsteka;
	}

	public byte getSakriven() {
		return sakriven;
	}

	public void setSakriven(byte sakriven) {
		this.sakriven = sakriven;
	}

	public byte getZatvoren() {
		return zatvoren;
	}

	public void setZatvoren(byte zatvoren) {
		this.zatvoren = zatvoren;
	}

	public byte getUspjesan() {
		return uspjesan;
	}

	public void setUspjesan(byte uspjesan) {
		this.uspjesan = uspjesan;
	}

	public Integer getPrioritet() {
		return prioritet;
	}

	public void setPrioritet(Integer prioritet) {
		this.prioritet = prioritet;
	}
    
    
}
