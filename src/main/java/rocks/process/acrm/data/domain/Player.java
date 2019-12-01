package rocks.process.acrm.data.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
public class Player {


    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Position position;
    private int scoredgoals;
    @ManyToOne
    @JsonBackReference
    private Team team;

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

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public int getScoredgoals() {
        return scoredgoals;
    }

    public void setScoredgoals(int scoredgoals) {
        this.scoredgoals = scoredgoals;
    }
}
