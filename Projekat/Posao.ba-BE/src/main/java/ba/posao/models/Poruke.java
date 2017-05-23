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

import org.joda.time.DateTime;


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
	
    @ManyToOne(targetEntity=Korisnik.class)
    @JoinColumn(name="idposiljaoca")
    private Korisnik posiljalac;
    
    public Korisnik getPosiljalac() {
		return posiljalac;
	}
	public void setPosiljalac(Korisnik posiljalac) {
		this.posiljalac = posiljalac;
	}
	public Korisnik getPrimalac() {
		return primalac;
	}
	public void setPrimalac(Korisnik primalac) {
		this.primalac = primalac;
	}
	@ManyToOne(targetEntity=Korisnik.class)
    @JoinColumn(name="idprimaoca")
    private Korisnik primalac;


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
	public Boolean getProcitano() {
		return procitano;
	}
	public void setProcitano(Boolean procitano) {
		this.procitano = procitano;
	}
	public Date getVrijeme() {
		return vrijeme;
	}
	public void setVrijeme(Date vrijeme) {
		this.vrijeme = vrijeme;
	}
	
	

}
