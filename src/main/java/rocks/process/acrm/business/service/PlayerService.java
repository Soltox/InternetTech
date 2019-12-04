package rocks.process.acrm.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import rocks.process.acrm.data.domain.Player;
import rocks.process.acrm.data.domain.Position;
import rocks.process.acrm.data.domain.Team;
import rocks.process.acrm.data.repository.PlayerRepository;
import rocks.process.acrm.data.repository.TeamRepository;

import javax.validation.Valid;
import java.util.List;

@Service
@Validated

public class PlayerService {

    public void PlayerService(){

    }

    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private TeamRepository teamRepository;


    public Player createPlayer(Player transmittedPlayer) {

        Player player = new Player();

        player.setName(transmittedPlayer.getName());
        player.setPosition(transmittedPlayer.getPosition());
        player.setScoredgoals(transmittedPlayer.getScoredgoals());
        playerRepository.save(player);
        System.out.println(player.getTeam());
        return player;
    }


    public Player addTeamToPlayer(long playerId, long teamId){

        Player player = playerRepository.findOnePlayerById(playerId);
        Team team = teamRepository.findOneTeamById(teamId);

        player.setTeam(team);

        team.getPlayer().add(player);

        playerRepository.save(player);
        teamRepository.save(team);

        return player;



    }

    public Player findPlayer(long playerId){

        Player player = playerRepository.findOnePlayerById(playerId);

        return player;
    }




}
