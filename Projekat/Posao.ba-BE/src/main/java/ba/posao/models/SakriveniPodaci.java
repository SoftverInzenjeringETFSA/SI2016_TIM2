package ba.posao.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="sakrivenipodaci")
public class SakriveniPodaci implements Serializable{

	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator="SharedPrimaryKeyGenerator")
    @GenericGenerator(name="SharedPrimaryKeyGenerator",strategy="foreign",parameters =  @Parameter(name="property", value="poslodavci"))
    @Column(name = "idposlodavca", unique = true, nullable = false)
	private Integer idposlodavca;

    @Column(name="privatnoime")
    private Boolean privatnoIme;
    @Column(name="privatnoprezime")
    private Boolean privatnoPrezime;
    @Column(name="privatnantelefon")
    private Boolean privatanTelefon;
    @Column(name="privatanemail")
    private Boolean privatanEmail;
	 
    
	public Integer getIdPoslodavca() {
		return idposlodavca;
	}
	public void setIdPoslodavca(Integer idPoslodavca) {
		this.idposlodavca = idPoslodavca;
	}
	public Boolean getPrivatnoIme() {
		return privatnoIme;
	}
	public void setPrivatnoIme(Boolean privatnoIme) {
		this.privatnoIme = privatnoIme;
	}
	public Boolean getPrivatnoPrezime() {
		return privatnoPrezime;
	}
	public void setPrivatnoPrezime(Boolean privatnoPrezime) {
		this.privatnoPrezime = privatnoPrezime;
	}
	public Boolean getPrivatanTelefon() {
		return privatanTelefon;
	}
	public void setPrivatanTelefon(Boolean privatanTelefon) {
		this.privatanTelefon = privatanTelefon;
	}
	public Boolean getPrivatanEmail() {
		return privatanEmail;
	}
	public void setPrivatanEmail(Boolean privatanEmail) {
		this.privatanEmail = privatanEmail;
	}
	
	
    
	
}
