package projectgestionpark.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Typevidange  {
  @Id @GeneratedValue(strategy = GenerationType.AUTO)

    private Long Id;
    private String libelle;
    private Long code;


     public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }
}

