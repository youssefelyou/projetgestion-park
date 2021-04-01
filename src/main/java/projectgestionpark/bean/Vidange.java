package projectgestionpark.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.util.Date;

@Entity
public class Vidange  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ref;
    @JsonFormat(pattern = "dd-mm-yyyy")
    private Date dateVidange;
    @ManyToOne
    private Typevidange typeVidange;
    private Double kilomtrageAcuel;
    private Double kilometrageVidangeSuivant;
    private Double montant;
    @ManyToOne
    private Voiture voiture;
    @OneToOne
    private Categorie categorie;

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

    public Date getDateVidange() {
        return dateVidange;
    }

    public void setDateVidange(Date dateVidange) {
        this.dateVidange = dateVidange;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCatégorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public Typevidange getTypeVidange() {
        return typeVidange;
    }

    public void setTypeVidange(Typevidange typeVidange) {
        this.typeVidange = typeVidange;
    }

    public Double getKilomtrageAcuel() {
        return kilomtrageAcuel;
    }

    public void setKilomtrageAcuel(Double kilomtrageAcuel) {
        this.kilomtrageAcuel = kilomtrageAcuel;
    }

    public Double getKilometrageVidangeSuivant() {
        return kilometrageVidangeSuivant;
    }

    public void setKilometrageVidangeSuivant(Double kilometrageVidangeSuivant) {
        this.kilometrageVidangeSuivant = kilometrageVidangeSuivant;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public Voiture getVoiture() {
        return voiture;
    }

    public void setVoiture(Voiture voiture) {
        this.voiture = voiture;
    }
}
