package ba.posao.models;

import java.io.Serializable;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PrimaryKeyJoinColumn;


@Entity
public class Korisnici implements Serializable {
	private static final long serialVersionUID = 1L;
	  
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="idkorisnika")
    private Integer idKorisnika;
    
    private String username;
    private String password;
    private String email;
    
   

    
    public Korisnici() {
    	
    }
    
    public Integer getId() {
    	return idKorisnika;
    }
    
    public void setId(Integer Id) {
    	this.idKorisnika = Id;
    }
    
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
