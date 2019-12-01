package rocks.process.acrm.data.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Match {
    @Id
    @GeneratedValue
    private Long id;
    private int homeTeamGoals;
    private int awayTeamGoals;
    private String location;
    @OneToMany(mappedBy = "league")
    private List<Team> teams;
    @ManyToOne
    @JsonBackReference
    private League league;

}

