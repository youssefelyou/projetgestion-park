package projectgestionpark.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Voiture  {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ref;
    @ManyToOne
    private TypeCarbu typeCarburant;
    private String matricule;
    @ManyToOne
    private Modele model;
    @JsonFormat(pattern = "dd-mm-yyyy")
    private Date dateDernierVidange;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public TypeCarbu getTypeCarburant() {
        return typeCarburant;
    }

    public void setTypeCarburant(TypeCarbu typeCarburant) {
        this.typeCarburant = typeCarburant;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public Modele getModel() {
        return model;
    }

    public void setModel(Modele refModel) {
        this.model = refModel;
    }

    public Date getDateDernierVidange() {
        return dateDernierVidange;
    }//change String to date

    public void setDateDernierVidange(Date dateDernierVidange) {
        this.dateDernierVidange = dateDernierVidange;
    }
    //change String to date


    public Voiture(Long id) {
        this.id = id;
    }

	public Voiture() {
		super();
		// TODO Auto-generated constructor stub
	}
  
}

