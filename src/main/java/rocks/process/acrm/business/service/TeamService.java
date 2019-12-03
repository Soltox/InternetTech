package rocks.process.acrm.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import rocks.process.acrm.data.domain.League;
import rocks.process.acrm.data.domain.Player;
import rocks.process.acrm.data.domain.Position;
import rocks.process.acrm.data.domain.Team;
import rocks.process.acrm.data.repository.LeagueRepository;
import rocks.process.acrm.data.repository.TeamRepository;

import javax.validation.Valid;
import java.util.List;

@Service
@Validated

public class TeamService {

    @Autowired
    private TeamRepository teamRepository;


    public Team createTeam(Team transmittedTeam) {

        Team team = new Team();
        team.setTeamname(transmittedTeam.getTeamname());

        if (transmittedTeam.getLeague() != null) {

            team.setLeague(transmittedTeam.getLeague());

        }

        teamRepository.save(team);

        return team;
    }


}
