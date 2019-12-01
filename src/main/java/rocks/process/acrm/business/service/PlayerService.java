package rocks.process.acrm.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import rocks.process.acrm.data.domain.Player;
import rocks.process.acrm.data.domain.Position;
import rocks.process.acrm.data.repository.PlayerRepository;

import javax.validation.Valid;
import java.util.List;

@Service
@Validated

public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;


    public Player createPlayer() {

        Player player = new Player();
        player.setName("Pascal");
        player.setPosition(Position.BACK);
        player.setScoredgoals(12);
        playerRepository.save(player);
        return player;
    }


}
