package ch.etmles.payroll.Entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.util.Objects;

public class Categorie {

    private @Id
    @GeneratedValue Long id;
    private String nom;

    public Categorie() {}

    public Categorie(String nom) {
        this.setNom(nom);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Categorie categorie)) return false;
        return Objects.equals(this.id, categorie.id) && Objects.equals(this.nom, categorie.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.nom);
    }

    @Override
    public String toString() {
        return "Lot{" +
                "id=" + id +
                ", nom='" + nom + '\''+
                '}';
    }
}

