package ba.posao.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="admin")
public class Admin implements Serializable {
	 private static final long serialVersionUID = 1L;
	 
	 @Id
	 @GeneratedValue(generator="SharedPrimaryKeyGenerator")
	 @GenericGenerator(name="SharedPrimaryKeyGenerator",strategy="foreign",parameters =  @Parameter(name="property", value="korisnici"))
	 @Column(name = "idkorisnika", unique = true, nullable = false)
	 private Integer idKorisnika;
	 	 

	 public Integer getId() {
	  	return idKorisnika;
	 }
	    
	 public void setId(Integer id) {
		 this.idKorisnika = id;
	 }
}