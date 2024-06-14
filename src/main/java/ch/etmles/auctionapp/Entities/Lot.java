package ch.etmles.auctionapp.Entities;

import jakarta.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

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
    private int articleNumber;

    @ManyToOne
    private Category category;
    @ManyToOne
    private Category subCategory;
    @ManyToOne
    private User user;
    @ManyToOne
    private State state;

    private static final AtomicInteger COUNTER = new AtomicInteger(1000);

    @PrePersist
    private void ensureArticleNumberAndState() {
        if (this.articleNumber == 0) {
            this.articleNumber = COUNTER.incrementAndGet();
        }
        if (this.state == null) {
            this.state = new State("En Cours"); // Vous devrez peut-être ajuster cela pour obtenir l'état "En Cours" depuis la base de données.
        }
    }

    public Lot() {}

    public Lot(String name, String description, Double startingPrice, Double actualPrice, Date startingDateHours, Date endingDateHours, Category category, Category subCategory, User user, State state) {
        this.name = name;
        this.description = description;
        this.startingPrice = startingPrice;
        this.actualPrice = actualPrice;
        this.startingDateHours = startingDateHours;
        this.endingDateHours = endingDateHours;
        this.category = category;
        this.subCategory = subCategory;
        this.user = user;
        this.state = state;
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

    public void setStartingPrice(Double startingPrice) {
        this.startingPrice = startingPrice;
    }

    public Double getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(Double actualPrice) {
        this.actualPrice = actualPrice;
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

    public int getArticleNumber() {
        return articleNumber;
    }

    public void setArticleNumber(int articleNumber) {
        this.articleNumber = articleNumber;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lot lot)) return false;
        return Objects.equals(id, lot.id) && Objects.equals(name, lot.name)
                && Objects.equals(description, lot.description) && Objects.equals(startingPrice, lot.startingPrice)
                && Objects.equals(startingDateHours, lot.startingDateHours) && Objects.equals(endingDateHours, lot.endingDateHours)
                && Objects.equals(category, lot.category) && Objects.equals(subCategory, lot.subCategory)
                && Objects.equals(user, lot.user) && articleNumber == lot.articleNumber && Objects.equals(state, lot.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, startingPrice, actualPrice, startingDateHours, endingDateHours, category, subCategory, user, articleNumber, state);
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
                ", articleNumber=" + articleNumber +
                ", state=" + state +
                '}';
    }
}
