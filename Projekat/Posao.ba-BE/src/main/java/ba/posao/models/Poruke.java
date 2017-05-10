package ba.posao.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Poruke implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idporuke")
	private Integer idPoruke;
	
	private String tekst;
	private Date vrijeme;
	private Boolean procitano;
	
    @ManyToOne(targetEntity=Nezaposleni.class)
    @JoinColumn(name="idnezaposlenog")
    private Nezaposleni idNezaposlenog;
    
    @ManyToOne(targetEntity=Poslodavci.class)
    @JoinColumn(name="idposlodavca")
    private Poslodavci idPoslodavca;

	public Nezaposleni getIdNezaposlenog() {
		return idNezaposlenog;
	}
	public void setIdNezaposlenog(Nezaposleni idNezaposlenog) {
		this.idNezaposlenog = idNezaposlenog;
	}
	public Poslodavci getIdPoslodavca() {
		return idPoslodavca;
	}
	public void setIdPoslodavca(Poslodavci idPoslodavca) {
		this.idPoslodavca = idPoslodavca;
	}

	public Integer getIdPoruke() {
		return idPoruke;
	}
	public void setIdPoruke(Integer idPoruke) {
		this.idPoruke = idPoruke;
	}
	public String getTekst() {
		return tekst;
	}
	public void setTekst(String tekst) {
		this.tekst = tekst;
	}
	public Date getVrijeme() {
		return vrijeme;
	}
	public void setVrijeme(Date vrijeme) {
		this.vrijeme = vrijeme;
	}
	public Boolean getProcitano() {
		return procitano;
	}
	public void setProcitano(Boolean procitano) {
		this.procitano = procitano;
	}
	

}
