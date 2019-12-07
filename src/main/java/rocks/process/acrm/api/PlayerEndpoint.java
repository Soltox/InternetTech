package rocks.process.acrm.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import rocks.process.acrm.business.service.PlayerService;
import rocks.process.acrm.data.domain.Player;
import rocks.process.acrm.data.repository.PlayerRepository;


import javax.validation.ConstraintViolationException;
import java.net.URI;

@RestController
@RequestMapping(path = "/api")
public class PlayerEndpoint {

    @Autowired
    private PlayerService playerService;


    @PostMapping(path = "/player", consumes = "application/json", produces = "application/json")
    public Player postPlayer(@RequestBody Player player) {
        try {

            playerService.createPlayer(player);



        } catch (ConstraintViolationException e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getConstraintViolations().iterator().next().getMessage());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
        }



        return player;

    }

    @DeleteMapping(path = "/player/{playerId}", consumes = "application/json", produces = "application/json")
    public void deletePlayer(@PathVariable(value = "playerId")Long playerId) {

        try {

            playerService.deletePlayer(playerId);



        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, e.getMessage());
        }


    }



    @GetMapping(path = "/player/delete/{playerId}", consumes = "application/json", produces = "application/json")
    public Player getPlayer(@PathVariable(value = "playerId")Long playerId) {
        Player player = null;
        try {

            player = playerService.findPlayer(playerId);



        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getMessage());
        }



        return player;

    }


    @PutMapping(path = "/player/{playerId}/{teamId}", consumes = "application/json", produces = "application/json")
    public Player putPlayer(@PathVariable(value = "playerId")String playerId,@PathVariable(value = "teamId")String teamId) {
        Player player = null;
        try {

            player = playerService.addTeamToPlayer(Long.parseLong(playerId),Long.parseLong(teamId));



        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getMessage());
        }



        return player;

    }




}
