package rocks.process.acrm.data.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;


@Entity

public class League {

    @Id
    @GeneratedValue
    private Long id;
    private String leaguename;
    @OneToMany
    private List<Team> teams;
    @OneToMany
    private List<Match> league;


}
