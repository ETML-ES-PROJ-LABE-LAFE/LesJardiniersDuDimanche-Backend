package ch.etmles.payroll.Entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
public class Lot {

    //TODO remove french content
    private @Id @GeneratedValue Long id;
    private String name;
    private String description;
    private Double startingPrice;

    private Double actualPrice;
    private @Temporal(TemporalType.TIMESTAMP) Date startingDateHours;
    private @Temporal(TemporalType.TIMESTAMP) Date endingDateHours;


    @ManyToOne
    private Category category;
    @ManyToOne
    private Category subCategory; // Ensure the property name is correct

    public Lot() {}

    public Lot(String nom, String description, Double prixDepart, Double actualPrice, Date dateHeureDebut, Date dateHeureFin, Category category, Category subcategory) {
        this.setName(nom);
        this.setDescription(description);
        this.setStartingPrice(prixDepart);
        this.setStartingDateHours(dateHeureDebut);
        this.setEndingDateHours(dateHeureFin);
        this.setCategory(category);
        this.setSubCategory(subcategory);
        this.setActualPrice(actualPrice);
    }

    // Getter and setter methods

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getStartingPrice() {
        return startingPrice;
    }

    public void setActualPrice(Double actualPrice) {
        this.actualPrice = actualPrice;
    }

    public Double getActualPrice() {
        return actualPrice;
    }

    public void setStartingPrice(Double startingPrice) {
        this.startingPrice = startingPrice;
    }

    public Date getStartingDateHours() {
        return startingDateHours;
    }

    public void setStartingDateHours(Date startingDateHours) {
        this.startingDateHours = startingDateHours;
    }

    public Date getEndingDateHours() {
        return endingDateHours;
    }

    public void setEndingDateHours(Date endingDateHours) {
        this.endingDateHours = endingDateHours;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Category getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(Category subCategory) {
        this.subCategory = subCategory;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lot lot)) return false;
        return Objects.equals(id, lot.id) && Objects.equals(name, lot.name)
                && Objects.equals(description, lot.description) && Objects.equals(startingPrice, lot.startingPrice)
                && Objects.equals(startingDateHours, lot.startingDateHours) && Objects.equals(endingDateHours, lot.endingDateHours)
                && category == lot.category && subCategory == lot.subCategory;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, startingPrice, startingDateHours, endingDateHours, category, subCategory);
    }

    @Override
    public String toString() {
        return "Lot{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", startingPrice=" + startingPrice +
                ", startingDateHours=" + startingDateHours +
                ", endingDateHours=" + endingDateHours +
                ", category=" + category +
                ", subCategory=" + subCategory +
                '}';
    }
}
