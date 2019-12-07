package rocks.process.acrm.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import rocks.process.acrm.business.service.LeagueService;
import rocks.process.acrm.data.domain.League;
import rocks.process.acrm.data.domain.Player;
import rocks.process.acrm.data.repository.LeagueRepository;


import javax.validation.ConstraintViolationException;
import java.net.URI;

@RestController
@RequestMapping(path = "/api")
public class LeagueEndpoint {

    @Autowired
    private LeagueService leagueService;


    @PostMapping(path = "/league", consumes = "application/json", produces = "application/json")
    public League postLeague(@RequestBody League league) {

        try {

            league = leagueService.createLeague(league);



        } catch (ConstraintViolationException e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getConstraintViolations().iterator().next().getMessage());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
        }


        return league;
    }

    @PostMapping(path = "/league/topscorer/{leagueId}", consumes = "application/json", produces = "application/json")
    public Player findTop(@PathVariable(value = "leagueId")Long leagueId) {
        Player player = null;
        try {

            player = leagueService.findTopScorer(leagueId);



        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getMessage());
        }



        return player;

    }


}
