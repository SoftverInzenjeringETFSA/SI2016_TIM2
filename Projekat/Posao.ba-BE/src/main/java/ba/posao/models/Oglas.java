package ba.posao.models;

import java.io.Serializable;
import java.util.Date;
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

@Entity
public class Oglas implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idoglasa")
	private Integer idOglasa;
	
    
    @ManyToOne(targetEntity=Poslodavci.class)
    @JoinColumn(name="idposlodavca")
    private Poslodavci poslodavac;
    
    @ManyToOne(targetEntity=Lokacije.class)
    @JoinColumn(name="idlokacije")
    private Lokacije lokacija;
    
    @ManyToOne(targetEntity=Kategorije.class)
    @JoinColumn(name="idkategorije")
    private Kategorije kategorije;
    
    @Column(name="datumobjave")
    private Date datumObjave;
    
    @Column(name="datumisteka") 
    private Date datumIsteka;
    private byte sakriven;
    private byte zatvoren;
    private byte uspjesan;
    
    private Integer prioritet;
    private String naziv;
    private String opis;
    
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE,targetEntity=OglasPodaci.class)
    @JoinColumn(name="idoglasa")
    private List<OglasPodaci> oglasPodaci;
    
    @OneToMany(cascade = CascadeType.MERGE,targetEntity=OglasPrijave.class)
    @JoinColumn(name="idprijave")
    private List<OglasPrijave> oglasPrijave;

	public List<OglasPrijave> getOglasPrijave() {
		return oglasPrijave;
	}

	public void setOglasPrijave(List<OglasPrijave> oglasPrijave) {
		this.oglasPrijave = oglasPrijave;
	}

	
	public Integer getIdOglasa() {
		return idOglasa;
	}

	public void setIdOglasa(Integer idOglasa) {
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

	public List<OglasPodaci> getOglasPodaci() {
		return oglasPodaci;
	}

	public void setOglasPodaci(List<OglasPodaci> oglasPodaci) {
		this.oglasPodaci = oglasPodaci;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}
    

	
	
    
}
