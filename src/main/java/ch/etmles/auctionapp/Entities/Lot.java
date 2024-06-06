package ch.etmles.auctionapp.Entities;

import jakarta.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
public class Lot {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    private Double startingPrice;
    private Double actualPrice;
    @Temporal(TemporalType.TIMESTAMP)
    private Date startingDateHours;
    @Temporal(TemporalType.TIMESTAMP)
    private Date endingDateHours;

    @ManyToOne
    private Category category;
    @ManyToOne
    private Category subCategory;

    @ManyToOne
    private User user;

    public Lot() {}

    public Lot(String nom, String description, Double prixDepart, Double actualPrice, Date dateHeureDebut, Date dateHeureFin, Category category, Category subcategory, User user) {
        this.setName(nom);
        this.setDescription(description);
        this.setStartingPrice(prixDepart);
        this.setStartingDateHours(dateHeureDebut);
        this.setEndingDateHours(dateHeureFin);
        this.setCategory(category);
        this.setSubCategory(subcategory);
        this.setActualPrice(actualPrice);
        this.setUser(user);
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lot lot)) return false;
        return Objects.equals(id, lot.id) && Objects.equals(name, lot.name)
                && Objects.equals(description, lot.description) && Objects.equals(startingPrice, lot.startingPrice)
                && Objects.equals(startingDateHours, lot.startingDateHours) && Objects.equals(endingDateHours, lot.endingDateHours)
                && Objects.equals(category, lot.category) && Objects.equals(subCategory, lot.subCategory)
                && Objects.equals(user, lot.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, startingPrice, startingDateHours, endingDateHours, category, subCategory, user);
    }

    @Override
    public String toString() {
        return "Lot{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", startingPrice=" + startingPrice +
                ", actualPrice=" + actualPrice +
                ", startingDateHours=" + startingDateHours +
                ", endingDateHours=" + endingDateHours +
                ", category=" + category +
                ", subCategory=" + subCategory +
                ", user=" + user +
                '}';
    }
}
