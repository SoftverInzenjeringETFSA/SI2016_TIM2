package ba.posao.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="kantoni")
public class Kantoni implements Serializable  {
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="idkantona")
    private Integer idKantona;
    private String  naziv;
    
    public Integer getId() {
        return idKantona;
    }
    
    public void setId(Integer id) {
        this.idKantona = id;
    }
    
    public String getNaziv() {
        return naziv;
    }
    
    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

	public Integer getIdKantona() {
		return idKantona;
	}

	public void setIdKantona(Integer idKantona) {
		this.idKantona = idKantona;
	}
    
}
