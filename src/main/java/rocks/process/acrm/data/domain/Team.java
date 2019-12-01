package rocks.process.acrm.data.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Team {


    @Id
    @GeneratedValue
    private Long id;
    private String teamname;
    @OneToMany(mappedBy = "team")
    private List<Player> player;
    @ManyToOne
    @JsonBackReference
    private League league;
}
