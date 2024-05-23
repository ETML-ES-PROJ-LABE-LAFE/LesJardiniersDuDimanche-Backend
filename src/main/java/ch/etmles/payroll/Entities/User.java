package ch.etmles.payroll.Entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "app_user")  // Changer le nom de la table pour éviter les conflits avec les mots réservés
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private boolean isConnected;

    private BigDecimal wallet;

    public User() {
    }

     public User(String name, String email, BigDecimal wallet) {
        this.name = name;
        this.email = email;
        this.isConnected = false; // Par défaut, l'utilisateur n'est pas connecté
        this.wallet = wallet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isConnected() {
        return isConnected;
    }

    public void setConnected(boolean isConnected) {
        this.isConnected = isConnected;
    }

      public BigDecimal getWallet() {
        return wallet;
    }

     public void setWallet(BigDecimal wallet) {
        this.wallet = wallet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return isConnected == user.isConnected && Objects.equals(id, user.id)
                && Objects.equals(name, user.name) && Objects.equals(email, user.email)
                && Objects.equals(wallet, user.wallet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, isConnected, wallet);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", isConnected=" + isConnected +
                ", wallet=" + wallet +
                '}';
    }
}
