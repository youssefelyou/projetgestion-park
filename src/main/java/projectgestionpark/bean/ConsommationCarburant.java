package projectgestionpark.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import java.util.Date;

@Entity

public class ConsommationCarburant  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ref;
    private Long annee;
    private Long mois;
    private Long numeroSemaine;
    private double litre;
    private double prix;
    private String description;
    @JsonFormat(pattern = "dd-mm-yyyy")
    private Date dateConsommationCarburant;
    @OneToOne
    private Voiture voiture;

    public Voiture getVoiture() {
        return voiture;
    }

    public void setVoiture(Voiture voiture) {
        this.voiture = voiture;
    }

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

    public Long getAnnee() {
        return annee;
    }

    public void setAnnee(Long annee) {
        this.annee = annee;
    }

    public long getMois() {
        return mois;
    }

    public void setMois(Long mois) {
        this.mois = mois;
    }

    public long getNumeroSemaine() {
        return numeroSemaine;
    }

    public void setNumeroSemaine(Long numeroSemaine) {
        this.numeroSemaine = numeroSemaine;
    }

    public double getLitre() {
        return litre;
    }

    public void setLitre(double litre) {
        this.litre = litre;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateConsommationCarburant() {
        return dateConsommationCarburant;
    }

    public void setDateConsommationCarburant(Date dateConsommationCarburant) {
        this.dateConsommationCarburant = dateConsommationCarburant;
    }
}


