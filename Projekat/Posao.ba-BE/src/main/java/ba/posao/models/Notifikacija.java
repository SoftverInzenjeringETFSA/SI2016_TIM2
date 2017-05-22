package ba.posao.models;

import java.util.Date;
import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Notifikacija implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="idnotifikacije")
	private Integer idNotifikacije;


	private String tekst;

	@Column(name="vrijemegenerisanja")
	private Date vrijemeGenerisanja;

	private Boolean pregledana;
	
    @ManyToOne(targetEntity=Korisnik.class)
    @JoinColumn(name="idkorisnika")
    private Korisnik korisnik;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idnotifikacije")
    private NotifikacijaPrijava notifikacijaPrijava;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idnotifikacije")
    private NotifikacijaPozivnica notifikacijaPozivnica;
    
	public NotifikacijaPozivnica getNotifikacijaPozivnica() {
		return notifikacijaPozivnica;
	}

	public void setNotifikacijaPozivnica(NotifikacijaPozivnica notifikacijaPozivnica) {
		this.notifikacijaPozivnica = notifikacijaPozivnica;
	}

	public NotifikacijaPrijava getNotifikacijaPrijava() {
		return notifikacijaPrijava;
	}

	public void setNotifikacijaPrijava(NotifikacijaPrijava notifikacijaPrijava) {
		this.notifikacijaPrijava = notifikacijaPrijava;
	}

	public Integer getIdNotifikacije() {
		return idNotifikacije;
	}

	public void setIdNotifikacije(Integer idNotifikacije) {
		this.idNotifikacije = idNotifikacije;
	}

	public String getTekst() {
		return tekst;
	}

	public void setTekst(String tekst) {
		this.tekst = tekst;
	}

	public Date getVrijemeGenerisanja() {
		return vrijemeGenerisanja;
	}

	public void setVrijemeGenerisanja(Date vrijemeGenerisanja) {
		this.vrijemeGenerisanja = vrijemeGenerisanja;
	}

	public Boolean getPregledana() {
		return pregledana;
	}

	public void setPregledana(Boolean pregledana) {
		this.pregledana = pregledana;
	}

	public Korisnik getKorisnik() {
		return korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}

}
