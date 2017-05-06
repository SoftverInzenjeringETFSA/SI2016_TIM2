package ba.posao.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Kantoni implements Serializable  {
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
}
