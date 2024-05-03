package ch.etmles.payroll.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.util.Date;
import java.util.Objects;

@Entity
public class Lot {

    private @Id @GeneratedValue Long id;
    private String nom;
    private String description;
    private Double prixDepart; // Attribut pour le prix de départ
    private @Temporal(TemporalType.TIMESTAMP) Date dateHeureDebut; // Date et heure de début avec annotation pour JPA
    private @Temporal(TemporalType.TIMESTAMP) Date dateHeureFin; // Date et heure de fin avec annotation pour JPA

    public Lot() {}

    public Lot(String nom, String description, Double prixDepart, Date dateHeureDebut, Date dateHeureFin) {
        this.setNom(nom);
        this.setDescription(description);
        this.setPrixDepart(prixDepart);
        this.setDateHeureDebut(dateHeureDebut);
        this.setDateHeureFin(dateHeureFin);
    }

    public Long getID() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrixDepart() {
        return prixDepart;
    }

    public void setPrixDepart(Double prixDepart) {
        this.prixDepart = prixDepart;
    }

    public Date getDateHeureDebut() {
        return dateHeureDebut;
    }

    public void setDateHeureDebut(Date dateHeureDebut) {
        this.dateHeureDebut = dateHeureDebut;
    }

    public Date getDateHeureFin() {
        return dateHeureFin;
    }

    public void setDateHeureFin(Date dateHeureFin) {
        this.dateHeureFin = dateHeureFin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lot lot)) return false;
        return Objects.equals(this.id, lot.id) && Objects.equals(this.nom, lot.nom)
                && Objects.equals(this.description, lot.description) && Objects.equals(this.prixDepart, lot.prixDepart)
                && Objects.equals(this.dateHeureDebut, lot.dateHeureDebut) && Objects.equals(this.dateHeureFin, lot.dateHeureFin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.nom, this.description, this.prixDepart, this.dateHeureDebut, this.dateHeureFin);
    }

    @Override
    public String toString() {
        return "Lot{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                ", prixDepart=" + prixDepart +
                ", dateHeureDebut=" + dateHeureDebut +
                ", dateHeureFin=" + dateHeureFin +
                '}';
    }
}
