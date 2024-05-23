package ch.etmles.payroll.Entities;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
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

}
