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
    public ResponseEntity<Player> postPlayer(@RequestBody Player player) {
        try {

            playerService.createPlayer();

            player = null;

        } catch (ConstraintViolationException e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getConstraintViolations().iterator().next().getMessage());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
        }

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{customerId}")
                .buildAndExpand(player.getId()).toUri();

        return ResponseEntity.created(location).body(player);

    }


}
