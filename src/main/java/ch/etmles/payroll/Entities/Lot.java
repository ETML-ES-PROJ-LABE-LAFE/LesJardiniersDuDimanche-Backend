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
    private Categorie categorie;

    public Lot() {}

    public Lot(String nom, String description, Double prixDepart, Date dateHeureDebut, Date dateHeureFin, Categorie categorie) {
        this.setNom(nom);
        this.setDescription(description);
        this.setPrixDepart(prixDepart);
        this.setDateHeureDebut(dateHeureDebut);
        this.setDateHeureFin(dateHeureFin);
        this.setCategorie(categorie);
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

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lot lot)) return false;
        return Objects.equals(id, lot.id) && Objects.equals(nom, lot.nom)
                && Objects.equals(description, lot.description) && Objects.equals(prixDepart, lot.prixDepart)
                && Objects.equals(dateHeureDebut, lot.dateHeureDebut) && Objects.equals(dateHeureFin, lot.dateHeureFin)
                && categorie == lot.categorie;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom, description, prixDepart, dateHeureDebut, dateHeureFin, categorie);
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
                ", categorie=" + categorie +
                '}';
    }
}
