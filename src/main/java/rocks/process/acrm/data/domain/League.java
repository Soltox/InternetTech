package rocks.process.acrm.data.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity

public class League {

    @Id
    @GeneratedValue
    private Long id;
    private String leaguename;



    @OneToMany(mappedBy = "league")
    private List<Match> allPlayedMatches;

    @OneToMany(mappedBy = "league")
    List<Team> allTeams;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLeaguename() {
        return leaguename;
    }

    public void setLeaguename(String leaguename) {
        this.leaguename = leaguename;
    }

    public List<Team> getAllTeams() {
        return allTeams;
    }

    public void setAllTeams(List<Team> allTeams) {
        this.allTeams = allTeams;
    }

    public List<Match> getAllPlayedMatches() {
        return allPlayedMatches;
    }

    public void setAllPlayedMatches(List<Match> allPlayedMatches) {
        this.allPlayedMatches = allPlayedMatches;
    }
}
