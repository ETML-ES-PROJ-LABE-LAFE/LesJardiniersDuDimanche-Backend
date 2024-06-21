package ch.etmles.auctionapp.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class State {

    @Id
    @GeneratedValue
    private Long id;

    private String stateName;

    public State() {}

    public State(String stateName) {
        this.stateName = stateName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof State state)) return false;
        return Objects.equals(id, state.id) && Objects.equals(stateName, state.stateName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, stateName);
    }

    @Override
    public String toString() {
        return "State{" +
                "id=" + id +
                ", stateName='" + stateName + '\'' +
                '}';
    }
}
