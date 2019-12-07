package rocks.process.acrm.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import rocks.process.acrm.data.domain.League;
import rocks.process.acrm.data.domain.Player;
import rocks.process.acrm.data.domain.Position;
import rocks.process.acrm.data.domain.Team;
import rocks.process.acrm.data.repository.LeagueRepository;

import javax.validation.Valid;
import java.util.List;

@Service
@Validated

public class LeagueService {

    @Autowired
    private LeagueRepository leagueRepository;


    public League createLeague(League transmittedLeague) {

        League league = new League();
        league.setLeaguename(transmittedLeague.getLeaguename());
        leagueRepository.save(league);
        return league;
    }

    public Player findTopScorer(Long leagueId){

        League currentleague = leagueRepository.findOneLeagueById(leagueId);

       List<Team> leagueteams = currentleague.getAllTeams();
       Player topscorer = null;


       for(int i = 0; i<leagueteams.size();i++){
           Team currentTeam = leagueteams.get(i);

           for(int r = 0;r<currentTeam.getPlayer().size();r++){

               if(currentTeam.getPlayer().get(r).getScoredgoals()>topscorer.getScoredgoals()){

                   topscorer = currentTeam.getPlayer().get(r);

               }


           }

       }

       return topscorer;
    }


}
