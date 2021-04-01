package projectgestionpark.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Reparation {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String ref;
	private String description;
	private double montant;
	@JsonFormat(pattern = "dd-mm-yyyy")
	private String dateReparation;
	 @ManyToOne
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
public String getDescription() {
	return description;
}
public void setDescription(String descriotion) {
	this.description = descriotion;
}
public double getMontant() {
	return montant;
}
public void setMontant(double montant) {
	this.montant = montant;
}
public String getDateReparation() {
	return dateReparation;
}
public void setDateReparation(String dateReparation) {
	this.dateReparation = dateReparation;
}

}
