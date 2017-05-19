package ba.posao.models;

import java.io.Serializable;
import java.util.Date;

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
@Table(name="oglasprijave")
public class OglasPrijave implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idprijave")
	private Integer idPrijave;
	
    @ManyToOne(targetEntity=Nezaposleni.class)
    @JoinColumn(name="idkorisnika")
    private Nezaposleni nezaposleni;
        
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name="idoglasa", nullable = false)
    private Oglas oglas;
    
    @Column(name="dodatneinformacije")
    private String dodatneInformacije;
    
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="vrijemeprijave")
    private Date vrijemePrijave;
	
    public Oglas getOglas() {
		return oglas;
	}

	public void setOglas(Oglas oglas) {
		this.oglas = oglas;
	}

	
	public Integer getIdPrijave() {
		return idPrijave;
	}

	public void setIdPrijave(Integer idPrijave) {
		this.idPrijave = idPrijave;
	}

	public Nezaposleni getNezaposleni() {
		return nezaposleni;
	}

	public void setNezaposleni(Nezaposleni nezaposleni) {
		this.nezaposleni = nezaposleni;
	}

	public String getDodatneInformacije() {
		return dodatneInformacije;
	}

	public void setDodatneInformacije(String dodatneInformacije) {
		this.dodatneInformacije = dodatneInformacije;
	}

	public Date getVrijemePrijave() {
		return vrijemePrijave;
	}

	public void setVrijemePrijave(Date vrijemePrijave) {
		this.vrijemePrijave = vrijemePrijave;
	}


}
