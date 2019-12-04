package rocks.process.acrm.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import rocks.process.acrm.business.service.LeagueService;
import rocks.process.acrm.business.service.TeamService;
import rocks.process.acrm.data.domain.League;
import rocks.process.acrm.data.domain.Player;
import rocks.process.acrm.data.domain.Team;
import rocks.process.acrm.data.repository.LeagueRepository;


import javax.validation.ConstraintViolationException;
import java.net.URI;

@RestController
@RequestMapping(path = "/api")
public class TeamEndpoint {

    @Autowired
    private TeamService teamService;


    @PostMapping(path = "/team", consumes = "application/json", produces = "application/json")
    public Team postTeam(@RequestBody Team team) {

        try {

            team = teamService.createTeam(team);


        } catch (ConstraintViolationException e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getConstraintViolations().iterator().next().getMessage());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
        }


        return team;
    }

    @GetMapping(path = "/team/{teamId}", consumes = "application/json", produces = "application/json")
    public int calcTeamGoals(@PathVariable(value = "teamId") Long teamId) {
        int allgoals;

        try {


            allgoals = teamService.calcAllGoals(teamId);

        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getMessage());
        }


        return allgoals;

    }




}
